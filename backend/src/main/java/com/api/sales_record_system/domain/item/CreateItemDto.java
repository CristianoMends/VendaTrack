package com.api.sales_record_system.domain.item;

import jakarta.validation.constraints.*;

public class CreateItemDto {

    @NotNull(message = "O preço não pode ser nulo.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero.")
    @Digits(integer = 10, fraction = 2, message = "O preço deve ter no máximo 10 dígitos no total, com no máximo 2 casas decimais.")
    private Double price;
    @NotBlank(message = "A descrição não pode estar em branco.")
    @Size(max = 255, message = "A descrição não pode ter mais de 255 caracteres.")
    private String description;

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

    public CreateItemDto(){}
    public CreateItemDto(Double price, String description) {
        this.price = price;
        this.description = description;
    }

}
