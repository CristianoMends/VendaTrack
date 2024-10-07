package com.api.sales_record_system.controller;

import com.api.sales_record_system.dto.*;
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
@RequestMapping("sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping()
    @CrossOrigin()
    public ResponseEntity<ResponseDto> registerSale(
            @RequestBody @Validated CreateSaleDto sale
            ){
        saleService.saveSale(sale);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("sale registered successfully", HttpStatus.OK.value()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteSale(
            @PathVariable Long id
    ){
        saleService.deleteSale(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("sale deleted successfully",HttpStatus.OK.value()));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> updateSale(@PathVariable Long id, @RequestBody UpdateSaleDto updateSaleDto){
        saleService.updateSale(id, updateSaleDto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("sale updated successfully",HttpStatus.OK.value()));
    }

    @GetMapping()
    @CrossOrigin()
    public ResponseEntity<List<SaleView>> getAllSales(){
        return ResponseEntity.status(HttpStatus.OK).body(saleService.getAll());
    }

    @PostMapping("/search")
    @CrossOrigin()
    public ResponseEntity<List<SaleView>> searchSales(@RequestBody SearchDto searchDto) {
        List<SaleView> results = saleService.searchSales(searchDto);
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }



}
