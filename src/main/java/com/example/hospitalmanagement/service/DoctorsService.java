package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.models.dto.request.DoctorDTO;
import com.example.hospitalmanagement.models.entity.Doctors;

import java.util.List;

public interface DoctorsService {
    List<Doctors> getAllDoctors();

    Doctors getDoctorById(Integer id);

    Doctors addDoctor(DoctorDTO doctorDTO);

    Doctors editDoctor(Integer id, DoctorDTO newDoctorDTO);

    Doctors patchDoctor(Integer id, DoctorDTO newDoctorDTO);

    void deleteDoctor(Integer id);


}
