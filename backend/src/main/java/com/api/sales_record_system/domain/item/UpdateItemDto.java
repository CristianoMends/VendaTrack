package com.api.sales_record_system.domain.item;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;

public class UpdateItemDto {

    private String description;
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero.")
    @Digits(integer = 10, fraction = 2, message = "O preço deve ter no máximo 10 dígitos no total, com no máximo 2 casas decimais.")
    private Double price;

    // Construtores
    public UpdateItemDto() {}

    public UpdateItemDto(String description, Double price) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
