package com.example.hospitalmanagement.models.dto.request;

import com.example.hospitalmanagement.models.entity.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatientsDTO {
    @NotBlank(message = "Không được để trống tên bệnh nhân")
    private String fullName;
    @NotBlank(message = "Không được để trống số điện thoại")
    private String phoneNumber;
    @NotNull(message = "Không được để trống ngày sinh")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotBlank(message = "Không được để trống địa chỉ")
    private String address;
}
