package com.api.sales_record_system.domain.sale;

import com.api.sales_record_system.adapters.out.entities.JpaSaleEntity;
import com.api.sales_record_system.domain.saleItem.SaleItem;
import com.api.sales_record_system.domain.enums.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Sale {

    private Long id;
    private List<SaleItem> items;
    private PaymentMethod paymentMethod;
    private LocalDateTime date;

    public Sale() {
    }

    public Sale(List<SaleItem> items, PaymentMethod paymentMethod, LocalDateTime date) {
        this.items = items;
        this.paymentMethod = paymentMethod;
        this.date = date;

    }

    public Sale(JpaSaleEntity saved) {
        this.id = saved.getId();
        this.date = saved.getDate();
        this.paymentMethod = saved.getPaymentMethod();

        if (saved.getItems() == null) return;
        this.items = saved.getItems()
                .stream()
                .map(SaleItem::new).toList();
    }

    public BigDecimal getTotal() {
        var tot = BigDecimal.valueOf(0);
        for (var a : this.items) {
            tot.add(a.getTotal());
        }
        return tot;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public void setItems(List<SaleItem> items) {
        this.items = items;
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

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", items=" + items +
                ", paymentMethod=" + paymentMethod +
                ", date=" + date +
                '}';
    }
}
