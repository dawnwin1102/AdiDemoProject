package com.leo.adidasdemo.routeportal.model;

import lombok.Data;


@Data
public class ResponseWarpper {
    private Integer status;
    private Object result;

    public ResponseWarpper(Integer status, Object result) {
        this.status = status;
        this.result = result;
    }

}
