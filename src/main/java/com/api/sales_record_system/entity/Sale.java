package com.api.sales_record_system.entity;

import com.api.sales_record_system.enums.PaymentMethod;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity()
@Table()
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private String description;
    private PaymentMethod paymentMethod;
    private LocalDateTime date;

    public Sale(){}

    public Sale(Double price, String description, PaymentMethod paymentMethod, LocalDateTime date) {
        this.price = price;
        this.description = description;
        this.paymentMethod = paymentMethod;
        this.date = date;
    }

    public Long getId() {return id;}
    public void setId(Long id) {
        this.id = id;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
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
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
