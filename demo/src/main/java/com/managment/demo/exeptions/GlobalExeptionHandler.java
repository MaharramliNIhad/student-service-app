package com.managment.demo.exeptions;

import com.managment.demo.dto.ExeptionResponse;
import com.managment.demo.enums.ErrorEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExeptionHandler {
    @ExceptionHandler(UserNotFound.class)
    public ExeptionResponse handleUserNotFoundException() {
        ExeptionResponse exeptionResponse = new ExeptionResponse();
        exeptionResponse.setMessage(ErrorEnum.USER_NOT_FOUND_ERROR.getErrorMessage())
                .setErrorCode(ErrorEnum.USER_NOT_FOUND_ERROR.getErrorCode())
                .setStatus(ErrorEnum.USER_NOT_FOUND_ERROR.getStatus())
                .setDateTime(LocalDateTime.now());
        return exeptionResponse;
    }
    @ExceptionHandler(EmailAlreadyExists.class)
    public ExeptionResponse handleEmailAlreadyExistsException() {
        ExeptionResponse exeptionResponse = new ExeptionResponse();
        exeptionResponse.setMessage(ErrorEnum.EMAIL_ALREADY_EXISTS_ERROR.getErrorMessage())
                .setErrorCode(ErrorEnum.EMAIL_ALREADY_EXISTS_ERROR.getErrorCode())
                .setStatus(ErrorEnum.EMAIL_ALREADY_EXISTS_ERROR.getStatus())
                .setDateTime(LocalDateTime.now());
        return exeptionResponse;
    }
}
