package org.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<ErrorClass> handleContactNotFoundException(ContactNotFoundException ex){
        String errMsg = ex.getMessage();
        ErrorClass error = new ErrorClass(
                HttpStatus.BAD_REQUEST.value(),
                errMsg,
                LocalDateTime.now()
        );

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
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}

