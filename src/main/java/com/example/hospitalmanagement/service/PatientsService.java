package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.models.dto.request.PatientsDTO;
import com.example.hospitalmanagement.models.entity.Patients;

import java.util.List;

public interface PatientsService {
    List<Patients> getAllPatients();

    Patients addPatient (PatientsDTO patientsDTO);
}
