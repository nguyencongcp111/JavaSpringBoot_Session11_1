
## Bảng Cấu Hình Và Lý Do Lựa Chọn Mã Lỗi

Hệ thống thống nhất sử dụng 4 mã lỗi tiêu chuẩn sau dựa trên các nguyên tắc thiết kế RESTful API:

| Tình huống thực tế | Mã HTTP Status | Tên Mã Lỗi | Lý do lựa chọn mã này (Rationale) |
| :--- | :--- | :--- | :--- |
| **TH1:** Bỏ trống trường bắt buộc (ví dụ: tên bệnh nhân) | `400` | `Bad Request` | Do cú pháp hoặc dữ liệu gửi lên từ Client không đúng với định dạng, cấu trúc quy định của API (Malformed request). |
| **TH2:** Không tìm thấy ID tài nguyên trong Database | `404` | `Not Found` | Máy chủ đã tìm kiếm trong Cơ sở dữ liệu nhưng không có bất kỳ bản ghi nào trùng khớp với ID được yêu cầu từ URL. |
| **TH3:** Sai logic nghiệp vụ/Dữ liệu đầu vào (ví dụ: ngày sinh ở tương lai) | `422` | `Unprocessable Entity` | Định dạng dữ liệu gửi lên hoàn toàn đúng (JSON chuẩn), nhưng máy chủ không thể xử lý vì nó vi phạm các quy tắc logic nghiệp vụ (Business rules). |
| **TH4:** Hệ thống gặp sự cố đột ngột (ví dụ: sập MySQL) | `500` | `Internal Server Error` | Dữ liệu Client gửi lên hoàn toàn hợp lệ, nhưng bản thân máy chủ gặp lỗi kỹ thuật, không thể hoàn thành tác vụ (Server-side crash). |