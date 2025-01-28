package com.managment.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


public enum ErrorEnum {
    USER_NOT_FOUND_ERROR("User not found",10, HttpStatus.NOT_FOUND.value()),
    EMAIL_ALREADY_EXISTS_ERROR("Email already exists",20, HttpStatus.CONFLICT.value()),;
    private String errorMessage;
    private Integer errorCode;
    private Integer status;
    private ErrorEnum(String errorMessage, Integer errorCode,Integer status) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public Integer getStatus() {
        return status;
    }
}
