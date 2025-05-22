package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<ErrorClass> handleContactNotFoundException(ContactNotFoundException ex){
        String errMsg = ex.getMessage();
        ErrorClass error = new ErrorClass(
                HttpStatus.BAD_REQUEST.value(),
                errMsg,
                LocalDateTime.now()
        );

        logger.warn("ContactNotFoundException: {}", errMsg, ex);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorClass> handleValidationException(MethodArgumentNotValidException ex){
        String errMsg = ex.getBindingResult().getFieldErrors().stream().
                map(fieldError -> fieldError.getField()+": "+fieldError.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ErrorClass error = new ErrorClass(
                HttpStatus.BAD_REQUEST.value(),
                errMsg,
                LocalDateTime.now()
        );
        logger.error("Validation failed: {}", errMsg, ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}