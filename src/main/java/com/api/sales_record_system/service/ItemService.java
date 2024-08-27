package com.api.sales_record_system.service;

import com.api.sales_record_system.dto.CreateItemDto;
import com.api.sales_record_system.dto.UpdateItemDto;
import com.api.sales_record_system.dto.ViewItemDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface ItemService {

    boolean saveItem(CreateItemDto createItemDto);
    List<ViewItemDto> getAllItens();
    boolean updateItem(UUID id, UpdateItemDto updateItemDto);
    boolean deleteItem(UUID id);
}
