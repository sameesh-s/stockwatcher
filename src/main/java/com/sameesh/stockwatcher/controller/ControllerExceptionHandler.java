package com.sameesh.stockwatcher.controller;

import com.sameesh.stockwatcher.dto.ApiError;
import com.sameesh.stockwatcher.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {BusinessException.class})
    public ResponseEntity<ApiError> bussinessException(BusinessException ex, WebRequest request) {
        ApiError message = new ApiError(
                ex.getMessage());

        return new ResponseEntity<ApiError>(message, HttpStatus.NOT_FOUND);
    }
}