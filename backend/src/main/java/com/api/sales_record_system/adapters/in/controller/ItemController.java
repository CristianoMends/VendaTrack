package com.api.sales_record_system.adapters.in.controller;

import com.api.sales_record_system.domain.item.CreateItemDto;
import com.api.sales_record_system.domain.item.UpdateItemDto;
import com.api.sales_record_system.domain.item.ViewItemDto;
import com.api.sales_record_system.application.useCases.ItemUseCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemUseCases itemService;

    @PostMapping
    public ResponseEntity<Void> saveItem(@RequestBody CreateItemDto createItemDto) {
        this.itemService.create(createItemDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ViewItemDto>> getAll() {
        return ResponseEntity.ok(this.itemService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(
            @PathVariable Long id
    ) {
        itemService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateItem(@PathVariable Long id, @RequestBody UpdateItemDto updateItemDto) {
        itemService.update(id, updateItemDto);
        return ResponseEntity.noContent().build();
    }
}
