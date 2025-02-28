package com.api.sales_record_system.adapters.in.controller;

import com.api.sales_record_system.domain.item.CreateItemDto;
import com.api.sales_record_system.domain.item.UpdateItemDto;
import com.api.sales_record_system.domain.item.ViewItemDto;
import com.api.sales_record_system.application.service.ItemService;
import com.api.sales_record_system.infrastructure.exception.ResponseError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemService itemService;
    @PostMapping
    public ResponseEntity<ResponseError> saveItem(@RequestBody CreateItemDto createItemDto){
        this.itemService.saveItem(createItemDto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseError("Item saved successfully",HttpStatus.OK.value()));
    }

    @GetMapping
    public ResponseEntity<List<ViewItemDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.itemService.getAllItens());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseError> deleteItem(
            @PathVariable UUID id
    ){
        itemService.deleteItem(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseError("Item deleted successfully", HttpStatus.OK.value()));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseError> updateItem(@PathVariable UUID id, @RequestBody UpdateItemDto updateItemDto){
        itemService.updateItem(id, updateItemDto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseError("Item updated successfully", HttpStatus.OK.value()));
    }
}
