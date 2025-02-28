package com.api.sales_record_system.infrastructure.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseError {

    private String message;
    private int statusCode;

    public ResponseError(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

}
