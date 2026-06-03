package com.example.hospitalmanagement.service.impl;

import com.example.hospitalmanagement.models.dto.request.PatientsDTO;
import com.example.hospitalmanagement.models.entity.Patients;
import com.example.hospitalmanagement.repository.PatientsRepository;
import com.example.hospitalmanagement.service.PatientsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
@Slf4j
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
        log.info("Có yêu cầu thêm bệnh nhân {}", patientsDTO.getFullName());

        int minus = Period.between(patientsDTO.getDob(), LocalDate.now()).getYears();

        if (minus > 120) {
            log.warn("Số tuổi bệnh nhân quá cao {}", minus);
        }

        Patients patient = Patients.builder()
                .fullName(patientsDTO.getFullName())
                .phoneNumber(patientsDTO.getPhoneNumber())
                .dob(patientsDTO.getDob())
                .gender(patientsDTO.getGender())
                .address(patientsDTO.getAddress())
                .build();

        Patients savedPatient = patientsRepository.save(patient);

        log.info("Bệnh nhân {} được thêm vào với id {}",
                savedPatient.getFullName(),
                savedPatient.getId());

        return savedPatient;
    }
}
