package com.example.hospitalmanagement.exception;

import com.example.hospitalmanagement.models.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception
    ) {
        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getFieldErrors()
                .forEach(fieldError -> {
                    errors.put(fieldError.getField(), fieldError.getDefaultMessage());
                });

        ErrorResponse response = new ErrorResponse<>();
        response.setMessage("Dữ liệu đầu vào không hợp lệ hoặc bị bỏ trống");
        response.setData(errors);
        response.setStatus(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
            ResourceNotFoundException exception
    ) {
        ErrorResponse response = new ErrorResponse<>();
        response.setMessage("Không tìm thấy dữ liệu");
        response.setData(exception.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorResponse> handleInvalidInputException(
            InvalidInputException exception
    ) {
        ErrorResponse response = new ErrorResponse<>();
        response.setMessage("Dữ liệu đầu vào không hợp lệ");
        response.setData(exception.getMessage());
        response.setStatus(HttpStatus.UNPROCESSABLE_CONTENT);

        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_CONTENT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleError(
            Exception exception
    ) {
        ErrorResponse response = new ErrorResponse<>();
        response.setMessage("Hệ thống xảy ra sự cố, vui lòng thử lại sau");
        response.setData(exception.getMessage());
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
