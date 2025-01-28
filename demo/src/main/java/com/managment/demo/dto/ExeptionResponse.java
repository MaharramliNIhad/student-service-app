package com.managment.demo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExeptionResponse {
    private String message;
    private Integer errorCode;
    private LocalDateTime dateTime;
    private Integer status;

    public String getMessage() {
        return message;
    }

    public ExeptionResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public ExeptionResponse setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public ExeptionResponse setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ExeptionResponse setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
