Cấu Trúc Class Định Nghĩa `ApiResponse`

Dưới đây là cấu trúc Java thuần chuẩn của Class Wrapper, sử dụng Generic `<T>` để có thể bọc bất kỳ loại dữ liệu nào:

public class ApiResponse<T> {
    private boolean status;
    private int code;
    private T data;
    private Meta meta;

    public String getStatus() {
        return this.status ? "success" : "error";
    }

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