package com.api.sales_record_system.controller;

import com.api.sales_record_system.dto.CreateSaleDto;
import com.api.sales_record_system.dto.SaleView;
import com.api.sales_record_system.dto.SearchDto;
import com.api.sales_record_system.dto.UpdateSaleDto;
import com.api.sales_record_system.entity.Sale;
import com.api.sales_record_system.service.SaleService;
import org.antlr.v4.runtime.atn.SemanticContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
@RequestMapping("sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping()
    public ResponseEntity<String> registerSale(
            @RequestBody @Validated CreateSaleDto sale
            ){
        saleService.saveSale(sale);
        return ResponseEntity.status(HttpStatus.CREATED).body("sale registered successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSale(
            @PathVariable Long id
    ){
        saleService.deleteSale(id);
        return ResponseEntity.status(HttpStatus.OK).body("sale deleted successfully");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateSale(@PathVariable Long id, @RequestBody UpdateSaleDto updateSaleDto){
        saleService.updateSale(id, updateSaleDto);
        return ResponseEntity.status(HttpStatus.OK).body("sale updated successfully");
    }

    @GetMapping()
    public ResponseEntity<List<SaleView>> getAllSales(){
        return ResponseEntity.status(HttpStatus.FOUND).body(saleService.getAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<SaleView>> searchSales(@RequestBody SearchDto searchDto) {
        List<SaleView> results = saleService.searchSales(searchDto);
        return ResponseEntity.ok(results);
    }



}
