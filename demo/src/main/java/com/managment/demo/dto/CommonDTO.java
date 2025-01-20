package com.managment.demo.dto;

import java.time.LocalDateTime;

public class CommonDTO {
    private Object object;
    private LocalDateTime date;
    private String message;

    public Object getObject() {
        return object;
    }

    public CommonDTO setObject(Object object) {
        this.object = object;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public CommonDTO setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommonDTO setMessage(String message) {
        this.message = message;
        return this;
    }
}
