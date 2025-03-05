package com.api.sales_record_system.domain.saleItem;

import com.api.sales_record_system.adapters.out.entities.JpaSaleItemEntity;
import com.api.sales_record_system.domain.item.Item;
import com.api.sales_record_system.domain.sale.Sale;

import java.math.BigDecimal;

public class SaleItem {

    private Long id;
    private Item item;
    private Sale sale;
    private int quantity;

    public SaleItem() {
    }

    public SaleItem(Item item, Sale sale, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.sale = sale;
    }

    public SaleItem(JpaSaleItemEntity jpaSaleItemEntity) {
        this.id = jpaSaleItemEntity.getId();
        this.quantity = jpaSaleItemEntity.getQuantity();
        this.item = new Item(jpaSaleItemEntity.getItem());
        //this.sale = new Sale(jpaSaleItemEntity.getSale());
    }

    public SaleItem(Item item, Sale sale) {
        this.item = item;
        this.sale = sale;
    }

    public BigDecimal getTotal() {
        if (this.item.getPrice() == null) return BigDecimal.valueOf(0);

        return this.item.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public ViewSaleItemDto toView() {
        return new ViewSaleItemDto(
                getId(),
                getItem().toView(),
                getQuantity()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SaleItem{" +
                "id=" + id +
                ", item=" + item +
                ", sale=" + sale.getId() +
                ", quantity=" + quantity +
                '}';
    }
}
