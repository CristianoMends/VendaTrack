package com.api.sales_record_system.entity;

import com.api.sales_record_system.enums.PaymentMethod;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity()
@Table()
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "sale")
    private List<SaleItem> itens;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private LocalDateTime date;

    public Sale(){}

    public Sale(List<SaleItem> itens, PaymentMethod paymentMethod, LocalDateTime date) {
        this.itens = itens;
        this.paymentMethod = paymentMethod;
        this.date = date;

    }

    public Double getTotal(){
        Double total = 0.0;
        for (SaleItem i : this.itens) {
            total += i.getTotal();
        }
        return total;
    }

    public List<SaleItem> getItens() {
        return itens;
    }

    public void setItens(List<SaleItem> itens) {
        this.itens = itens;
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

    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
