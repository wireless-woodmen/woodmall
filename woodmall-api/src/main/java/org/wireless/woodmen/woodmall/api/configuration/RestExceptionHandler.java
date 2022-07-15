package org.wireless.woodmen.woodmall.api.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.wireless.woodmen.woodmall.common.constant.ExceptionConstants;
import org.wireless.woodmen.woodmall.common.constant.LogConstants;
import org.wireless.woodmen.woodmall.common.model.ExceptionResponse;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<ExceptionResponse> handleInternalServerError(Exception exception) {
        return ResponseEntity.ok(new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage()));
    }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
            String errorMessage = exception.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + " : " + fieldError.getDefaultMessage())
                .reduce((a, b) -> a + "\n" + b).orElse("");
            return ResponseEntity.badRequest()
                .body(new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), errorMessage));
    }
    
    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity<ExceptionResponse> handleConstraintViolationException(ConstraintViolationException exception) {
        String exceptionMessages = exception.getConstraintViolations().stream()
            .map(ConstraintViolation::getMessage)
            .reduce((a, b) -> a + "\n" + b)
            .orElse("");
        log.error(LogConstants.Formats.EXCEPTION_MESSAGES, exceptionMessages);
        return ResponseEntity.ok(new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ExceptionConstants.DEFAULT_MESSAGE));
    }
}
