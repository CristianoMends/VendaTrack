package com.api.vendas_track.application.service;

import com.api.vendas_track.domain.item.*;
import com.api.vendas_track.infrastructure.exception.BusinessException;
import com.api.vendas_track.application.useCases.ItemUseCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemUseCases {
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public void create(CreateItemDto createItemDto) {
        itemRepository.save(toEntity(createItemDto));
    }

    @Override
    public List<ViewItemDto> getAll() {
        var res = itemRepository.findAll();
        return res.stream().map(this::toView).toList();
    }


    @Override
    public void update(Long id, UpdateItemDto updateItemDto) {
        var itemOptional = itemRepository.findById(id);
        if (itemOptional.isEmpty()) {
            throw new BusinessException("Item with " + id + " not found.");
        }
        Item item = itemOptional.get();

        if (updateItemDto.getPrice() != null){
            item.setPrice(updateItemDto.getPrice());
        }
        if (updateItemDto.getDescription() != null){
            item.setDescription(updateItemDto.getDescription());
        }

        itemRepository.save(item);
    }

    @Override
    public void delete(Long id) {
        if (this.itemRepository.findById(id).isEmpty()){
            throw new BusinessException("Item with Long "+id+" not found");
        }
        this.itemRepository.deleteById(id);
    }

    private Item toEntity(CreateItemDto i){
        return new Item(
                i.getPrice(), i.getDescription()
        );
    }
    private ViewItemDto toView(Item i){
        return new ViewItemDto(
                i.getId(),
                i.getPrice(),
                i.getDescription()
        );
    }
}
