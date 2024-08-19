package com.api.sales_record_system.dto;

import com.api.sales_record_system.enums.PaymentMethod;
import jakarta.validation.constraints.*;

public class CreateSaleDto {

    @NotNull(message = "O preço não pode ser nulo.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero.")
    @Digits(integer = 10, fraction = 2, message = "O preço deve ter no máximo 10 dígitos no total, com no máximo 2 casas decimais.")
    private Double price;
    @NotBlank(message = "A descrição não pode estar em branco.")
    @Size(max = 255, message = "A descrição não pode ter mais de 255 caracteres.")
    private String description;

    @NotNull(message = "O método de pagamento não pode ser nulo.")
    private PaymentMethod paymentMethod;

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
