package com.api.vendas_track.adapters.out.entities;

import com.api.vendas_track.domain.item.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

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
