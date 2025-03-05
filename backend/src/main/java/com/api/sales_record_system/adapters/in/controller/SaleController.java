package com.api.sales_record_system.adapters.in.controller;

import com.api.sales_record_system.domain.enums.PaymentMethod;
import com.api.sales_record_system.domain.sale.CreateSaleDto;
import com.api.sales_record_system.domain.sale.ViewSaleDto;
import com.api.sales_record_system.application.useCases.SaleUseCases;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("sale")
public class SaleController {

    @Autowired
    private SaleUseCases saleService;

    @PostMapping()
    @CrossOrigin()
    public ResponseEntity<Void> create(
            @RequestBody @Valid CreateSaleDto sale
    ) {
        saleService.save(sale);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        saleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    @CrossOrigin()
    public ResponseEntity<List<ViewSaleDto>> list(Long id,
                                                  PaymentMethod paymentMethod,
                                                  LocalDateTime dateStart,
                                                  LocalDateTime dateEnd,
                                                  Long itemId) {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.list(id,
                paymentMethod,
                dateStart,
                dateEnd,
                itemId));
    }

}
