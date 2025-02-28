package com.api.sales_record_system.application.service;

import com.api.sales_record_system.domain.sale.CreateSaleDto;
import com.api.sales_record_system.domain.sale.ViewSaleDto;
import com.api.sales_record_system.domain.sale.UpdateSaleDto;
import com.api.sales_record_system.domain.sale.Sale;

import java.util.List;

public interface SaleService {
    boolean saveSale(CreateSaleDto createSaleDto);

    List<ViewSaleDto> searchSales();

    Sale updateSale(Long saleId, UpdateSaleDto updateSaleDto);

    boolean deleteSale(Long id);

    List<ViewSaleDto> getAll();

}
