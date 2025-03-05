package com.api.sales_record_system.domain.item;

import java.util.Optional;
import java.util.List;

public interface ItemRepository {

    Optional<Item> save(Item item);

    Optional<Item> findById(Long id);

    List<Item> findAll();

    void deleteById(Long id);

}
