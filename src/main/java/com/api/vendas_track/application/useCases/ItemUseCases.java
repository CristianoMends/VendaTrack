package com.api.vendas_track.application.useCases;

import com.api.vendas_track.domain.item.CreateItemDto;
import com.api.vendas_track.domain.item.UpdateItemDto;
import com.api.vendas_track.domain.item.ViewItemDto;

import java.util.List;

public interface ItemUseCases {

    void create(CreateItemDto createItemDto);
    List<ViewItemDto> getAll();
    void update(Long id, UpdateItemDto updateItemDto);
    void delete(Long id);
}
