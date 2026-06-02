package com.example.hospitalmanagement.models.dto.request;

import com.example.hospitalmanagement.models.entity.MeetingStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class MeetingsDTO {
    @NotNull(message = "Không được bỏ trống id bác sĩ")
    private Integer doctorId;
    @NotNull(message = "Không được bỏ trồng id bệnh nhân")
    private Integer patientId;
    @NotNull(message = "Không được bỏ trống ngày giờ cuộc hẹn")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime appointmentTime;
    @NotNull(message = "Không được bỏ trống lý do")
    private String reason;
    @NotNull(message = "Không được bỏ trống trạng thái")
    private MeetingStatus status;

}
