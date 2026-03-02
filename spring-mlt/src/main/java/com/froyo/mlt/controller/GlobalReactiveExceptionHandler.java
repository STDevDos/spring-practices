package com.froyo.mlt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class GlobalReactiveExceptionHandler {

    /**
     * Sophia uses @ControllerAdvice to handle errors gracefully in a reactive application.
     * This handles exceptions across all reactive controllers asynchronously.
     */
    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<String>> handleException(Exception ex) {
        return Mono.just(ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Reactive Error: " + ex.getMessage()));
    }
}
