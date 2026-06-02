

### A. Quản Lý Cuộc Hẹn Khám (`/api/meetings`)
| Thao tác | HTTP Method | API Endpoint | Ghi chú |
| :--- | :--- | :--- | :--- |
| **Lấy lịch hẹn theo Bác sĩ** | `GET` | `/api/doctors/{doctorId}/meetings` | Truy vấn toàn bộ danh sách lịch khám của 1 bác sĩ cụ thể |

### B. Quản Lý Bệnh Nhân & Đơn Thuốc (Nested Resources)
Hệ thống sử dụng cấu trúc URL lồng nhau để thể hiện rõ ràng quyền sở hữu dữ liệu:

| Thao tác | HTTP Method | API Endpoint | Ghi chú |
| :--- | :--- | :--- | :--- |
| **Kê đơn thuốc mới** | `POST` | `/api/patients/{patientId}/prescriptions` | Tạo đơn thuốc mới cho một bệnh nhân xác định |
| **Xem đơn thuốc cụ thể**| `GET` | `/api/patients/{patientId}/prescriptions/{prescriptionId}` | Truy vấn đích danh 1 đơn thuốc dựa trên cả ID đơn và ID bệnh nhân |