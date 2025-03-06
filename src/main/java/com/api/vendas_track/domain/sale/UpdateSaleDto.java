package com.api.vendas_track.domain.sale;

import com.api.vendas_track.domain.enums.PaymentMethod;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateSaleDto {

    @NotBlank(message = "A descrição não pode estar vazia.")
    private String description;

    @NotNull(message = "O preço não pode ser nulo.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero.")
    @Digits(integer = 10, fraction = 2, message = "O preço deve ter no máximo 10 dígitos no total, com no máximo 2 casas decimais.")
    private Double price;

    @NotNull(message = "O método de pagamento não pode ser nulo.")
    private PaymentMethod paymentMethod;

    // Construtores
    public UpdateSaleDto() {}

    public UpdateSaleDto(String description, Double price, PaymentMethod paymentMethod) {
        this.description = description;
        this.price = price;
        this.paymentMethod = paymentMethod;
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

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
