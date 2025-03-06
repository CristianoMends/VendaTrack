package com.api.vendas_track.domain.sale;

import com.api.vendas_track.domain.enums.PaymentMethod;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.List;

public class CreateSaleDto {

    @NotNull(message = "itens não pode ser nulo.")
    private List<CreateSaleItemDto> itens;
    private LocalDateTime date;
    @NotNull(message = "O método de pagamento não pode ser nulo.")
    private PaymentMethod paymentMethod;

    public List<CreateSaleItemDto> getItens() {
        return itens;
    }

    public void setItens(List<CreateSaleItemDto> itens) {
        this.itens = itens;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public CreateSaleDto(List<CreateSaleItemDto> itens, LocalDateTime date, PaymentMethod paymentMethod) {
        this.itens = itens;
        this.date = date;
        this.paymentMethod = paymentMethod;
    }
}
