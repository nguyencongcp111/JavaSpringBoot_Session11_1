package com.example.hospitalmanagement.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse<T> {
    private boolean status;
    private int code;
    private T data;
    private Meta meta;

    public String getStatus() {
        return this.status ? "success" : "error";
    }

    @Getter
    public static class Meta {
        // Getters và Setters cho Meta
        private long totalItems;  // Tổng số bản ghi
        private int currentPage; // Trang hiện tại

        public Meta(long totalItems, int currentPage) {
            this.totalItems = totalItems;
            this.currentPage = currentPage;
        }

    }
}
