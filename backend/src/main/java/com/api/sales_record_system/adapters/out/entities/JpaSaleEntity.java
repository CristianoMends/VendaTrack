package com.api.sales_record_system.adapters.out.entities;


import com.api.sales_record_system.domain.enums.PaymentMethod;
import com.api.sales_record_system.domain.sale.Sale;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "sale")
public class JpaSaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "sale", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<JpaSaleItemEntity> items;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private LocalDateTime date;

    public JpaSaleEntity() {
    }

    public JpaSaleEntity(List<JpaSaleItemEntity> items, PaymentMethod paymentMethod, LocalDateTime date) {
        this.items = items;
        this.paymentMethod = paymentMethod;
        this.date = date;
    }

    public JpaSaleEntity(Sale sale) {
        this(sale, true);
    }

    JpaSaleEntity(Sale sale, boolean includeItems) {
        this.id = sale.getId();
        this.date = sale.getDate();
        this.paymentMethod = sale.getPaymentMethod();

        if (includeItems && sale.getItems() != null) {
            this.items = sale.getItems()
                    .stream()
                    .map(JpaSaleItemEntity::new)
                    .toList();
        }
    }




    public BigDecimal getTotal() {
        var total = BigDecimal.ZERO;
        for (var i : this.items) {
            total.add(i.getTotal());
        }
        return total;
    }

    @Override
    public String toString() {
        return "JpaSaleEntity{" +
                "id=" + id +
                ", items=" + items +
                ", paymentMethod=" + paymentMethod +
                ", date=" + date +
                '}';
    }
}

