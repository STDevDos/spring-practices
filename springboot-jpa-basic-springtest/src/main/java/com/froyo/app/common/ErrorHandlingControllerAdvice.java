package com.froyo.app.common;

import com.froyo.messages.AbstractResponse;
import com.froyo.messages.MessagePair;
import com.froyo.messages.MessagePairTypeCode;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;

import jakarta.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

@ControllerAdvice
@ResponseBody
public class ErrorHandlingControllerAdvice {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ValidationErrorResponse onConstraintValidationException(final ConstraintViolationException ex) {
        ValidationErrorResponse error = new ValidationErrorResponse();
        error.addMessagePair(new MessagePair(ex.getConstraintName(), ex.getCause().getMessage(), MessagePairTypeCode.ERROR));
        return error;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ValidationErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        ValidationErrorResponse error = new ValidationErrorResponse();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            error.addMessagePair(new MessagePair(fieldError.getField(), fieldError.getDefaultMessage(), MessagePairTypeCode.ERROR));
        }
        return error;
    }

    @ExceptionHandler({MultipartException.class, AccessDeniedException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ValidationErrorResponse onMultiException(final Exception exception, final HttpServletRequest request) {

        ValidationErrorResponse error = new ValidationErrorResponse();
        error.addMessagePair(new MessagePair(request.getRequestURI(), exception.getMessage(), MessagePairTypeCode.ERROR));
        return error;
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ValidationErrorResponse onHttpMessageNotReadableException(final Exception exception,
                                                              final HttpServletRequest request) {

        ValidationErrorResponse error = new ValidationErrorResponse();
        error.addMessagePair(new MessagePair(request.getRequestURI(), "Required request body is missing", MessagePairTypeCode.ERROR));
        return error;
    }

    public static class ValidationErrorResponse extends AbstractResponse {

        private static final long serialVersionUID = 2783134686197167411L;

    }

}

