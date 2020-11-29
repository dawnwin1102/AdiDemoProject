package com.leo.adidasdemo.routeservice.itineraryservice.exception;

import lombok.Data;

/**
 * Global Exception Class
 */
@Data
public class GlobalException extends RuntimeException {
    private CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg) {
        super(codeMsg.toString());
        this.codeMsg = codeMsg;
    }
}

