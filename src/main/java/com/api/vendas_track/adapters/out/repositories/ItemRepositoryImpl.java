package com.api.vendas_track.adapters.out.repositories;

import com.api.vendas_track.adapters.out.entities.JpaItemEntity;
import com.api.vendas_track.domain.item.Item;
import com.api.vendas_track.domain.item.ItemRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private final JpaItemRepository jpaItemRepository;

    public ItemRepositoryImpl(JpaItemRepository jpaItemRepository) {
        this.jpaItemRepository = jpaItemRepository;
    }

    @Override
    public Optional<Item> save(Item item) {
        JpaItemEntity itemEntity = new JpaItemEntity(item);
        JpaItemEntity saved = this.jpaItemRepository.save(itemEntity);

        return Optional.of(new Item(saved.getId(), saved.getDescription(), saved.getPrice()));
    }

    @Override
    public Optional<Item> findById(Long id) {
        return Optional.ofNullable(this.jpaItemRepository.findById(id)
                .stream()
                .map(entity -> new Item(entity.getId(), entity.getDescription(), entity.getPrice()))
                .toList()
                .getFirst());
    }

    @Override
    public List<Item> findAll() {
        return this.jpaItemRepository.findAll().stream().map(entity -> new Item(entity.getId(), entity.getDescription(), entity.getPrice())).toList();
    }

    @Override
    public void deleteById(Long id) {
        this.jpaItemRepository.deleteById(id);
    }
}
