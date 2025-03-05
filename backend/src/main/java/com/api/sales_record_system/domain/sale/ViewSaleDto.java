package com.api.sales_record_system.domain.sale;

import com.api.sales_record_system.domain.saleItem.SaleItem;
import com.api.sales_record_system.domain.enums.PaymentMethod;
import com.api.sales_record_system.domain.saleItem.ViewSaleItemDto;

import java.time.LocalDateTime;
import java.util.List;

public class ViewSaleDto {

    private Long id;
    private List<ViewSaleItemDto> itens;
    private PaymentMethod paymentMethod;
    private LocalDateTime date;

    public ViewSaleDto(Long id, List<SaleItem> itens, PaymentMethod paymentMethod, LocalDateTime date) {
        this.id = id;
        this.itens = itens.stream().map(SaleItem::toView).toList();
        this.paymentMethod = paymentMethod;
        this.date = date;
    }

    public List<ViewSaleItemDto> getItens() {
        return itens;
    }

    public void setItens(List<ViewSaleItemDto> itens) {
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

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
