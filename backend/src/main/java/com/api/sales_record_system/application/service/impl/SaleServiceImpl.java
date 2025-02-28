package com.api.sales_record_system.application.service.impl;

import com.api.sales_record_system.domain.sale.CreateSaleDto;
import com.api.sales_record_system.domain.sale.ViewSaleDto;
import com.api.sales_record_system.domain.sale.UpdateSaleDto;
import com.api.sales_record_system.domain.sale.Sale;
import com.api.sales_record_system.domain.enums.PaymentMethod;
import com.api.sales_record_system.infrastructure.exception.BusinessException;
import com.api.sales_record_system.adapters.out.repository.SaleRepository;
import com.api.sales_record_system.application.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
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
        sale.getItens().forEach(i -> {
            i.setSale(savedSale);
        });

        saleRepository.save(savedSale);

        return true;
    }

    @Override
    public List<ViewSaleDto> searchSales() {
        return new ArrayList<>();
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
    public List<ViewSaleDto> getAll() {
        return saleRepository.findAll().stream().map(this::toView).toList();
    }


    private Sale toEntity(CreateSaleDto createSaleDto) {
        return new Sale(
                createSaleDto.getItens(),
                createSaleDto.getPaymentMethod(),
                getZonedDateTimeNow()
        );
    }

    private LocalDateTime getZonedDateTimeNow() {
        ZoneId saoPauloZone = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime saoPauloDateTime = ZonedDateTime.now(saoPauloZone);
        return saoPauloDateTime.toLocalDateTime();
    }

    private LocalDateTime getZonedDateTimeInit() {
        ZoneId saoPauloZone = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime saoPauloDateTime = ZonedDateTime.of(LocalDateTime.of(2000, 1, 1, 5, 0), saoPauloZone);
        return saoPauloDateTime.toLocalDateTime();
    }

    private ViewSaleDto toView(Sale sale) {
        return new ViewSaleDto(
                sale.getId(),
                sale.getItens(),
                sale.getPaymentMethod(),
                sale.getDate()
        );
    }
}
