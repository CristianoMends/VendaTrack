package com.api.sales_record_system.service.impl;

import com.api.sales_record_system.dto.CreateSaleDto;
import com.api.sales_record_system.dto.UpdateSaleDto;
import com.api.sales_record_system.entity.Sale;
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
    }/*

    @Override
    public List<Sale> getSalesByDate(LocalDateTime initDate, LocalDateTime finalDate) {
        return null;
    }

    @Override
    public Sale updateSale(UpdateSaleDto updateSaleDto) {
        return null;
    }

    @Override
    public Sale deleteSale(Long id) {
        return null;
    }

    @Override
    public List<Sale> getAll() {
        return saleRepository.findAll();
    }*/

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
}
