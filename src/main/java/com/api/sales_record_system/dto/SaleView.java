package com.api.sales_record_system.dto;

import com.api.sales_record_system.entity.SaleItem;
import com.api.sales_record_system.enums.PaymentMethod;

import java.time.LocalDateTime;
import java.util.List;

public class SaleView {

    private Long id;
    private List<SaleItem> itens;
    private PaymentMethod paymentMethod;
    private LocalDateTime date;

    public SaleView(Long id, List<SaleItem> itens, PaymentMethod paymentMethod, LocalDateTime date) {
        this.id = id;
        this.itens = itens;
        this.paymentMethod = paymentMethod;
        this.date = date;
    }

    public List<SaleItem> getItens() {
        return itens;
    }

    public void setItens(List<SaleItem> itens) {
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
