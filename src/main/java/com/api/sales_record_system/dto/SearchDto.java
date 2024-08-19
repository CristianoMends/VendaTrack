package com.api.sales_record_system.dto;

import com.api.sales_record_system.enums.PaymentMethod;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class SearchDto {

    private String description;

    @NotNull(message = "O preço mínimo não pode ser nulo.")
    @DecimalMin(value = "0.0", inclusive = true, message = "O preço mínimo deve ser maior ou igual a zero.")
    private Double minPrice;

    @NotNull(message = "O preço máximo não pode ser nulo.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço máximo deve ser maior que zero.")
    private Double maxPrice;

    @NotNull(message = "A data de início não pode ser nula.")
    private LocalDateTime startDate;

    @NotNull(message = "A data de término não pode ser nula.")
    @FutureOrPresent(message = "A data de término deve ser no presente ou no futuro.")
    private LocalDateTime endDate;

    private PaymentMethod paymentMethod;

    public SearchDto() {
    }

    public SearchDto(String description, Double minPrice, Double maxPrice, LocalDateTime startDate, LocalDateTime endDate, PaymentMethod paymentMethod) {
        this.description = description;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.paymentMethod = paymentMethod;
    }

    // Getters e Setters

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @AssertTrue(message = "O preço máximo deve ser maior que o preço mínimo.")
    public boolean isMaxPriceGreaterThanMinPrice() {
        return maxPrice == null || minPrice == null || maxPrice > minPrice;
    }

    @AssertTrue(message = "A data de término deve ser posterior à data de início.")
    public boolean isEndDateAfterStartDate() {
        return endDate == null || startDate == null || endDate.isAfter(startDate);
    }
}
