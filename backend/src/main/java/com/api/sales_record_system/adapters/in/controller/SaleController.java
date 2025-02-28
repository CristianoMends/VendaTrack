package com.api.sales_record_system.adapters.in.controller;

import com.api.sales_record_system.domain.sale.CreateSaleDto;
import com.api.sales_record_system.domain.sale.UpdateSaleDto;
import com.api.sales_record_system.domain.sale.ViewSaleDto;
import com.api.sales_record_system.application.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping()
    @CrossOrigin()
    public ResponseEntity<Void> create(
            @RequestBody @Validated CreateSaleDto sale
    ) {
        saleService.saveSale(sale);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        saleService.deleteSale(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateSale(@PathVariable Long id, @RequestBody UpdateSaleDto updateSaleDto) {
        saleService.updateSale(id, updateSaleDto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    @CrossOrigin()
    public ResponseEntity<List<ViewSaleDto>> getAllSales() {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.getAll());
    }

    @PostMapping("/search")
    @CrossOrigin()
    public ResponseEntity<List<ViewSaleDto>> searchSales() {

        return ResponseEntity.ok().build();
    }


}
