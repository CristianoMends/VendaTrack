package com.api.sales_record_system.dto;

import com.api.sales_record_system.entity.Item;
import com.api.sales_record_system.entity.Sale;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class SaleItemDto {
    private Item item;
    private int quantity;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SaleItemDto(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}
