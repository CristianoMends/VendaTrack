package com.api.sales_record_system.adapters.out.entities;

import com.api.sales_record_system.domain.item.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "item")
public class JpaItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private BigDecimal price;
    private String description;

    public JpaItemEntity() {}

    public JpaItemEntity(Item item) {
        this.id = item.getId();
        this.description = item.getDescription();
        this.price = item.getPrice();
    }
}
