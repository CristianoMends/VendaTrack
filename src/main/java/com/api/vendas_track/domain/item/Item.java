package com.api.vendas_track.domain.item;

import com.api.vendas_track.adapters.out.entities.JpaItemEntity;

import java.math.BigDecimal;


public class Item {

    private Long id;
    private BigDecimal price;
    private String description;

    public Item() {
    }

    public Item(BigDecimal price, String description) {
        this.price = price;
        this.description = description;
    }
    public Item(JpaItemEntity item) {
        if (item != null) {
            this.id = item.getId();
            this.description = item.getDescription();
            this.price = item.getPrice();
        }
    }


    public Item(Long id, String description, BigDecimal price) {
        this.id = id;
        this.price = price;
        this.description = description;
    }

    public ViewItemDto toView() {
        return new ViewItemDto(
                getId(),
                getPrice(),
                getDescription()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
