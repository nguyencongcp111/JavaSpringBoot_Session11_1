package com.example.hospitalmanagement.service.impl;

import com.example.hospitalmanagement.models.dto.request.PatientsDTO;
import com.example.hospitalmanagement.models.entity.Patients;
import com.example.hospitalmanagement.repository.PatientsRepository;
import com.example.hospitalmanagement.service.PatientsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PatientsServiceImpl implements PatientsService {
    private final PatientsRepository patientsRepository;

    @Override
    public List<Patients> getAllPatients(){
        return patientsRepository.findAll();
    }

    @Override
    public Patients addPatient (PatientsDTO patientsDTO){
        Patients patient = Patients.builder()
                .fullName(patientsDTO.getFullName())
                .phoneNumber(patientsDTO.getPhoneNumber())
                .dob(patientsDTO.getDob())
                .gender(patientsDTO.getGender())
                .address(patientsDTO.getAddress())
                .build();
        return patientsRepository.save(patient);
    }
}
