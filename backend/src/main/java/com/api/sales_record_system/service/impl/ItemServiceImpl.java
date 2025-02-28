package com.api.sales_record_system.service.impl;

import com.api.sales_record_system.dto.CreateItemDto;
import com.api.sales_record_system.dto.UpdateItemDto;
import com.api.sales_record_system.dto.UpdateSaleDto;
import com.api.sales_record_system.dto.ViewItemDto;
import com.api.sales_record_system.entity.Item;
import com.api.sales_record_system.entity.Sale;
import com.api.sales_record_system.exception.BusinessException;
import com.api.sales_record_system.repository.ItemRepository;
import com.api.sales_record_system.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public boolean saveItem(CreateItemDto createItemDto) {
        itemRepository.save(toEntity(createItemDto));
        return true;
    }

    @Override
    public List<ViewItemDto> getAllItens() {
        var res = itemRepository.findAll();
        return res.stream().map(this::toView).toList();
    }


    @Override
    public boolean updateItem(UUID id, UpdateItemDto updateItemDto) {
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
        return true;
    }

    @Override
    public boolean deleteItem(UUID id) {
        if (this.itemRepository.findById(id).isEmpty()){
            throw new BusinessException("Item with UUID "+id+" not found");
        }
        this.itemRepository.deleteById(id);
        return true;
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
