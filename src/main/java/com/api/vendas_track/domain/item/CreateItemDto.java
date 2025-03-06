package com.api.vendas_track.domain.item;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class CreateItemDto {

    private BigDecimal price;
    @Size(max = 255, message = "A descrição não pode ter mais de 255 caracteres.")
    private String description;

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

    public CreateItemDto(){}
    public CreateItemDto(BigDecimal price, String description) {
        this.price = price;
        this.description = description;
    }

}
