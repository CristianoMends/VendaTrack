package com.api.sales_record_system.domain.saleItem;

import com.api.sales_record_system.domain.item.ViewItemDto;

public class ViewSaleItemDto {

    private Long id;
    private ViewItemDto item;
    private int quantity;

    public ViewSaleItemDto() {}

    public ViewSaleItemDto(Long id, ViewItemDto item, int quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ViewItemDto getItem() {
        return item;
    }

    public void setItem(ViewItemDto item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
