Cấu Trúc Class Định Nghĩa `ErrorResponse` Mới:

public class ErrorResponse<T> {
    private LocalDateTime timestamp;
    private int code;
    private String error;
    private T message;
    private String path;
}