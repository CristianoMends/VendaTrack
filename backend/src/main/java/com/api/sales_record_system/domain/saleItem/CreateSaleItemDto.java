package com.api.sales_record_system.domain.saleItem;

import com.api.sales_record_system.domain.item.Item;

public class CreateSaleItemDto {
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

    public CreateSaleItemDto(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}
