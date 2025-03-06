package com.api.vendas_track.domain.item;

import java.math.BigDecimal;

public class ViewItemDto {

    private Long id;
    private BigDecimal price;
    private String description;

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

    public ViewItemDto() {
    }

    public ViewItemDto(Long id, BigDecimal price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
    }

}
