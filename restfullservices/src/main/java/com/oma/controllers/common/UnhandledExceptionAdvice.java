package com.oma.controllers.common;

import com.oma.controllers.managestock.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by dev on 02/11/16.
 */
@ControllerAdvice
public class UnhandledExceptionAdvice {
        @ExceptionHandler(Throwable.class)
        public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
            ErrorResponse error = new ErrorResponse();
            error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            error.setMessage("Please contact your administrator");
            return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
        }
}
