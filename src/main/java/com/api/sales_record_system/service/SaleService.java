package com.api.sales_record_system.service;

import com.api.sales_record_system.dto.CreateSaleDto;
import com.api.sales_record_system.dto.UpdateSaleDto;
import com.api.sales_record_system.entity.Sale;

import java.time.LocalDateTime;
import java.util.List;

public interface SaleService {
    Sale saveSale(CreateSaleDto createSaleDto);
    /*List<Sale> getSalesByDate(LocalDateTime initDate, LocalDateTime finalDate);

    Sale updateSale(UpdateSaleDto updateSaleDto);

    Sale deleteSale(Long id);

    List<Sale> getAll();*/

}
