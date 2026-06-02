# 🏥 Danh Sách API Endpoints Quản Lý Bác Sĩ (Chuẩn RESTful)

Dưới đây là thiết kế đường dẫn chuẩn cho các thao tác CRUD đối với tài nguyên `doctors`:

### 1. Lấy danh sách toàn bộ bác sĩ
* **Method:** `GET`
* **URL:** `/api/doctors`

### 2. Lấy thông tin chi tiết một bác sĩ
* **Method:** `GET`
* **URL:** `/api/doctors/{id}`

### 3. Thêm mới một bác sĩ
* **Method:** `POST`
* **URL:** `/api/doctors`

### 4. Cập nhật thông tin bác sĩ
* **Method:** `PUT` (hoặc `PATCH`)
* **URL:** `/api/doctors/{id}`

### 5. Xóa bác sĩ khỏi hệ thống
* **Method:** `DELETE`
* **URL:** `/api/doctors/{id}`