package com.api.sales_record_system.service.impl;

import com.api.sales_record_system.dto.CreateSaleDto;
import com.api.sales_record_system.dto.SaleView;
import com.api.sales_record_system.dto.SearchDto;
import com.api.sales_record_system.dto.UpdateSaleDto;
import com.api.sales_record_system.entity.Sale;
import com.api.sales_record_system.enums.PaymentMethod;
import com.api.sales_record_system.exception.BusinessException;
import com.api.sales_record_system.repository.SaleRepository;
import com.api.sales_record_system.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public boolean saveSale(CreateSaleDto createSaleDto) {
        Sale sale = toEntity(createSaleDto);
        var id = saleRepository.save(sale).getId();
        var savedSale = saleRepository.findById(id).get();
        sale.getItens().forEach(i ->{
            i.setSale(savedSale);
        });

        saleRepository.save(savedSale);

        return true;
    }

    @Override
    public List<SaleView> searchSales(SearchDto searchDto) {
        var now = getZonedDateTimeNow();

        if (searchDto.getDescription() == null){
            searchDto.setDescription("");
        }
        if (searchDto.getEndDate() == null){
            searchDto.setEndDate(now);
        }
        if (searchDto.getEndDate().isAfter(now)){
            searchDto.setEndDate(now);
        }
        if (searchDto.getStartDate() == null){
            searchDto.setStartDate(getZonedDateTimeInit());
        }
        if (searchDto.getStartDate().isAfter(searchDto.getEndDate())){
            searchDto.setStartDate(getZonedDateTimeInit());
        }

        if (searchDto.getMinPrice() > searchDto.getMaxPrice() || searchDto.getMinPrice() == null){
            searchDto.setMinPrice(Double.MIN_VALUE);
        }
        if (searchDto.getMaxPrice() == null){
            searchDto.setMinPrice(Double.MAX_VALUE);
        }

        if (searchDto.getPaymentMethod() == null){
            searchDto.setPaymentMethod(PaymentMethod.UNDEFINED);
        }

        var result = saleRepository.findByFilters(
                searchDto.getDescription(),
                searchDto.getPaymentMethod(),
                searchDto.getMinPrice(),
                searchDto.getMaxPrice(),
                searchDto.getStartDate(),
                searchDto.getEndDate()
        );
        return result.stream().map(this::toView).toList();
    }

    @Override
    public Sale updateSale(Long saleId, UpdateSaleDto updateSaleDto) {
        var saleOptional = saleRepository.findById(saleId);
        if (saleOptional.isEmpty()) {
            throw new BusinessException("Venda com ID " + saleId + " não encontrada.");
        }
        Sale sale = saleOptional.get();
        if (updateSaleDto.getPaymentMethod() != null) {
            sale.setPaymentMethod(updateSaleDto.getPaymentMethod());
        }

        return saleRepository.save(sale);
    }


    @Override
    public boolean deleteSale(Long id) {
        if (saleRepository.findById(id).isEmpty()) {
            throw new BusinessException("Sale Not Found");
        }
        saleRepository.deleteById(id);
        return true;
    }

    @Override
    public List<SaleView> getAll() {
        return saleRepository.findAll().stream().map(this::toView).toList();
    }


    private Sale toEntity(CreateSaleDto createSaleDto) {
        return new Sale(
                createSaleDto.getItens(),
                createSaleDto.getPaymentMethod(),
                getZonedDateTimeNow()
        );
    }

    private LocalDateTime getZonedDateTimeNow(){
        ZoneId saoPauloZone = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime saoPauloDateTime = ZonedDateTime.now(saoPauloZone);
        return saoPauloDateTime.toLocalDateTime();
    }

    private LocalDateTime getZonedDateTimeInit(){
        ZoneId saoPauloZone = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime saoPauloDateTime = ZonedDateTime.of(LocalDateTime.of(2000,1,1,5,0),saoPauloZone);
        return saoPauloDateTime.toLocalDateTime();
    }
    private SaleView toView(Sale sale) {
        return new SaleView(
                sale.getId(),
                sale.getItens(),
                sale.getPaymentMethod(),
                sale.getDate()
        );
    }
}
