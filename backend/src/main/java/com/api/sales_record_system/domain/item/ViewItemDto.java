package com.api.sales_record_system.domain.item;

import java.util.UUID;

public class ViewItemDto {

    private UUID id;
    private Double price;
    private String description;

    public UUID getId() { return id; }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ViewItemDto(){}
    public ViewItemDto(UUID id, Double price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
    }

}
