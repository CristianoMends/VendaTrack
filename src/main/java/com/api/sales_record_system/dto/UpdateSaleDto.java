package com.api.sales_record_system.dto;

import com.api.sales_record_system.enums.PaymentMethod;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateSaleDto {

    @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero.")
    private Double price;

    @Size(max = 255, message = "A descrição não pode ter mais de 255 caracteres.")
    private String description;

    private PaymentMethod paymentMethod;

    // Construtores, Getters e Setters

    public UpdateSaleDto() {}

    public UpdateSaleDto(Double price, String description, PaymentMethod paymentMethod) {
        this.price = price;
        this.description = description;
        this.paymentMethod = paymentMethod;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
