package com.api.sales_record_system.controller;

import com.api.sales_record_system.dto.*;
import com.api.sales_record_system.service.ItemService;
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
    public ResponseEntity<ResponseDto> saveItem(@RequestBody CreateItemDto createItemDto){
        this.itemService.saveItem(createItemDto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("Item saved successfully",HttpStatus.OK.value()));
    }

    @GetMapping
    public ResponseEntity<List<ViewItemDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.itemService.getAllItens());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteItem(
            @PathVariable UUID id
    ){
        itemService.deleteItem(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("Item deleted successfully", HttpStatus.OK.value()));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> updateItem(@PathVariable UUID id, @RequestBody UpdateItemDto updateItemDto){
        itemService.updateItem(id, updateItemDto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("Item updated successfully", HttpStatus.OK.value()));
    }
}
