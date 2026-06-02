package com.example.hospitalmanagement.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse<T> {
    private String message;
    private T data;
    private HttpStatus status;
}
