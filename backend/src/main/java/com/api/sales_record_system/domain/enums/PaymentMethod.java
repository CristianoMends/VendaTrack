package com.api.sales_record_system.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PaymentMethod {

    PIX,
    DEBIT,
    CREDIT,
    MONEY,
    UNDEFINED;
}
