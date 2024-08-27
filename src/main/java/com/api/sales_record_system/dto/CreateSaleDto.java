package com.api.sales_record_system.dto;

import com.api.sales_record_system.entity.SaleItem;
import com.api.sales_record_system.enums.PaymentMethod;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.List;

public class CreateSaleDto {

    @NotNull(message = "itens não pode ser nulo.")
    private List<SaleItem> itens;
    private LocalDateTime date;
    @NotNull(message = "O método de pagamento não pode ser nulo.")
    private PaymentMethod paymentMethod;

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<SaleItem> getItens() {
        return itens;
    }

    public void setItens(List<SaleItem> itens) {
        this.itens = itens;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public CreateSaleDto(){}
    public CreateSaleDto(List<SaleItem> itens, PaymentMethod paymentMethod) {
        this.itens = itens;
        this.paymentMethod = paymentMethod;
    }
}
