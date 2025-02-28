package com.api.sales_record_system.application.service;

import com.api.sales_record_system.domain.item.CreateItemDto;
import com.api.sales_record_system.domain.item.UpdateItemDto;
import com.api.sales_record_system.domain.item.ViewItemDto;

import java.util.List;
import java.util.UUID;

public interface ItemService {

    boolean saveItem(CreateItemDto createItemDto);
    List<ViewItemDto> getAllItens();
    boolean updateItem(UUID id, UpdateItemDto updateItemDto);
    boolean deleteItem(UUID id);
}
