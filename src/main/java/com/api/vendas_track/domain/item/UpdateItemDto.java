package com.api.vendas_track.domain.item;

import java.math.BigDecimal;

public class UpdateItemDto {

    private String description;
    private BigDecimal price;

    // Construtores
    public UpdateItemDto() {}

    public UpdateItemDto(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }

    // Getters e Setters

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
