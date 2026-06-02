package com.example.hospitalmanagement.models.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PrescriptionsDTO {
    @NotBlank(message = "Không được bỏ trống trạng thái")
    private String diagnosis;
    @NotNull(message = "Không được bỏ trống ngày kê đơn")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime createdAt;
    @NotNull(message = "Không được bỏ trống id bác sĩ")
    private Integer doctorId;
    @NotNull(message = "Không được bỏ trồng id bệnh nhân")
    private Integer patientId;
}
