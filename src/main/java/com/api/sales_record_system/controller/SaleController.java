package com.api.sales_record_system.controller;

import com.api.sales_record_system.dto.CreateSaleDto;
import com.api.sales_record_system.dto.UpdateSaleDto;
import com.api.sales_record_system.entity.Sale;
import com.api.sales_record_system.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping()
    public ResponseEntity<Sale> registerSale(
            @RequestBody @Validated CreateSaleDto sale
            ){
        return ResponseEntity.status(HttpStatus.CREATED).body(saleService.saveSale(sale));
    }



}
