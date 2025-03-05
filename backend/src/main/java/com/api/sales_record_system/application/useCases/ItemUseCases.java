package com.api.sales_record_system.application.useCases;

import com.api.sales_record_system.domain.item.CreateItemDto;
import com.api.sales_record_system.domain.item.UpdateItemDto;
import com.api.sales_record_system.domain.item.ViewItemDto;

import java.util.List;
import java.util.UUID;

public interface ItemUseCases {

    void create(CreateItemDto createItemDto);
    List<ViewItemDto> getAll();
    void update(Long id, UpdateItemDto updateItemDto);
    void delete(Long id);
}
