package com.api.sales_record_system.dto;

import com.api.sales_record_system.enums.PaymentMethod;

import java.time.LocalDateTime;

public class SaleView {

    private Double price;
    private String description;
    private PaymentMethod paymentMethod;

    private LocalDateTime date;

    public SaleView(Double price, String description, PaymentMethod paymentMethod, LocalDateTime date) {
        this.price = price;
        this.description = description;
        this.paymentMethod = paymentMethod;
        this.date = date;
    }

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
