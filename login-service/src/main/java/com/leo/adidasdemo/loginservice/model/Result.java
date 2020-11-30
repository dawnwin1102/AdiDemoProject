package com.leo.adidasdemo.loginservice.model;

import lombok.Data;

import java.util.Map;

@Data
public class Result {
private boolean result;

    public Result(boolean result, String description, Map<String, String> info) {
        this.result = result;
        this.description = description;
        this.info = info;
    }

    private String description;
private Map<String,String> info;
}
