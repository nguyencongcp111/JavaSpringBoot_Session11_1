package com.example.hospitalmanagement.exception;

import com.example.hospitalmanagement.models.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception,
            WebRequest request
    ) {
        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getFieldErrors()
                .forEach(fieldError -> {
                    errors.put(fieldError.getField(), fieldError.getDefaultMessage());
                });

        HttpStatus status = HttpStatus.BAD_REQUEST;

        String path = request.getDescription(false).replace("uri=", "");

        ErrorResponse response = new ErrorResponse<>();
        response.setTimestamp(LocalDateTime.now());
        response.setCode(status.value());
        response.setError(status.name());
        response.setMessage(errors);
        response.setPath(path);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
            ResourceNotFoundException exception,
            WebRequest request
    ) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        String path = request.getDescription(false).replace("uri=", "");

        ErrorResponse response = new ErrorResponse<>();
        response.setTimestamp(LocalDateTime.now());
        response.setCode(status.value());
        response.setError(status.name());
        response.setMessage(exception.getMessage());
        response.setPath(path);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorResponse> handleInvalidInputException(
            InvalidInputException exception,
            WebRequest request
    ) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_CONTENT;

        String path = request.getDescription(false).replace("uri=", "");

        ErrorResponse response = new ErrorResponse<>();
        response.setTimestamp(LocalDateTime.now());
        response.setCode(status.value());
        response.setError(status.name());
        response.setMessage(exception.getMessage());
        response.setPath(path);

        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_CONTENT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleError(
            Exception exception,
            WebRequest request
    ) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        String path = request.getDescription(false).replace("uri=", "");

        ErrorResponse response = new ErrorResponse<>();
        response.setTimestamp(LocalDateTime.now());
        response.setCode(status.value());
        response.setError(status.name());
        response.setMessage(exception.getMessage());
        response.setPath(path);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
