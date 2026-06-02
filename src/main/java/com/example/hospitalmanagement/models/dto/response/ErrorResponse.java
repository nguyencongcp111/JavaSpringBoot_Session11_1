package com.example.hospitalmanagement.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse<T> {
    private LocalDateTime timestamp;
    private int code;
    private String error;
    private T message;
    private String path;
}
