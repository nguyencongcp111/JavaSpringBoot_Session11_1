package com.example.hospitalmanagement.models.dto.request;

import com.example.hospitalmanagement.models.entity.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    @NotBlank(message = "Không được để trống tên bác sĩ")
    private String fullName;
    @NotBlank(message = "Không được để trống email")
    @Email(message = "Email không đúng định dạng")
    private String email;
    @NotBlank(message = "Không được để trống số điện thoại")
    @Pattern(regexp = "^0[35789]\\d{8}$", message = "Số điện thoại không đúng định dạng")
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotNull(message = "Không được để trống ngày sinh")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dob;
    @NotBlank(message = "Không được để trống chuyên ngành")
    private String specialization;
}
