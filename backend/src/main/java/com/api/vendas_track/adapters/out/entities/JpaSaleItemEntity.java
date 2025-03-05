package com.api.vendas_track.adapters.out.entities;

import com.api.vendas_track.domain.saleItem.SaleItem;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "sale_item")
public class JpaSaleItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private JpaItemEntity item;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    @JsonBackReference
    private JpaSaleEntity sale;

    private int quantity;

    public JpaSaleItemEntity() {
    }


    public JpaSaleItemEntity(SaleItem saleItem) {
        this.id = saleItem.getId();
        this.quantity = saleItem.getQuantity();
        this.item = new JpaItemEntity(saleItem.getItem());

        // Evita a chamada recursiva
        if (saleItem.getSale() != null) this.sale = new JpaSaleEntity(saleItem.getSale(), false);
    }


    public BigDecimal getTotal() {
        return this.item.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public String toString() {
        return "JpaSaleItemEntity{" +
                "id=" + id +
                ", item=" + item +
                ", sale=" + sale.getId() +
                ", quantity=" + quantity +
                '}';
    }
}