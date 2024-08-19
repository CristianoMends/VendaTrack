package com.api.sales_record_system.service;

import com.api.sales_record_system.dto.CreateSaleDto;
import com.api.sales_record_system.dto.SaleView;
import com.api.sales_record_system.dto.SearchDto;
import com.api.sales_record_system.dto.UpdateSaleDto;
import com.api.sales_record_system.entity.Sale;

import java.time.LocalDateTime;
import java.util.List;

public interface SaleService {
    Sale saveSale(CreateSaleDto createSaleDto);

    List<SaleView> searchSales(SearchDto searchDto);

    //Sale updateSale(UpdateSaleDto updateSaleDto);

    boolean deleteSale(Long id);

    List<SaleView> getAll();

}
