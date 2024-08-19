package com.api.sales_record_system.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PaymentMethod {

    PIX,
    DEBIT,
    CREDIT,
    MONEY;

    @JsonCreator
    public static PaymentMethod fromString(String value) {
        for (PaymentMethod paymentMethod : PaymentMethod.values()) {
            if (paymentMethod.name().equalsIgnoreCase(value)) {
                return paymentMethod;
            }
        }
        throw new IllegalArgumentException("Invalid Payment Method: " + value);
    }

}
