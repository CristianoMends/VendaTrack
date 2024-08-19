package com.api.sales_record_system.service.impl;

import com.api.sales_record_system.dto.CreateSaleDto;
import com.api.sales_record_system.dto.SaleView;
import com.api.sales_record_system.dto.SearchDto;
import com.api.sales_record_system.dto.UpdateSaleDto;
import com.api.sales_record_system.entity.Sale;
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
    public Sale saveSale(CreateSaleDto createSaleDto) {
        Sale sale = toEntity(createSaleDto);
        return saleRepository.save(sale);
    }

    @Override
    public List<SaleView> searchSales(SearchDto searchDto) {
        var now = LocalDateTime.now();

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
    public boolean deleteSale(Long id) {
        if(saleRepository.findById(id).isEmpty()){
            throw new BusinessException("Sale Not Found");
        }
        saleRepository.deleteById(id);
        return true;
    }

    @Override
    public List<SaleView> getAll() {
        return saleRepository.findAll().stream().map(this::toView).toList();
    }


    private Sale toEntity(CreateSaleDto createSaleDto){
        ZoneId saoPauloZone = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime saoPauloDateTime = ZonedDateTime.now(saoPauloZone);
        LocalDateTime localDateTime = saoPauloDateTime.toLocalDateTime();
        return new Sale(
                createSaleDto.getPrice(),
                createSaleDto.getDescription(),
                createSaleDto.getPaymentMethod(),
                localDateTime
        );
    }
    private SaleView toView(Sale sale){
        return new SaleView(
                sale.getPrice(),
                sale.getDescription(),
                sale.getPaymentMethod(),
                sale.getDate()
        );
    }
}
