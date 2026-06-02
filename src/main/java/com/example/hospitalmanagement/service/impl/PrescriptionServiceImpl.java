package com.example.hospitalmanagement.service.impl;

import com.example.hospitalmanagement.exception.ResourceNotFoundException;
import com.example.hospitalmanagement.models.dto.request.PrescriptionsDTO;
import com.example.hospitalmanagement.models.entity.Doctors;
import com.example.hospitalmanagement.models.entity.Patients;
import com.example.hospitalmanagement.models.entity.Prescriptions;
import com.example.hospitalmanagement.repository.DoctorsRepository;
import com.example.hospitalmanagement.repository.PatientsRepository;
import com.example.hospitalmanagement.repository.PrescriptionsRepository;
import com.example.hospitalmanagement.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {
    private final PrescriptionsRepository prescriptionsRepository;
    private final DoctorsRepository doctorsRepository;
    private final PatientsRepository patientsRepository;

    @Override
    public Prescriptions getPrescriptionByIdAndPatientId
            (Integer patientId, Integer prescriptionId) {
        return prescriptionsRepository.getPrescriptionByIdAndPatientId
                (patientId, prescriptionId);
    }

    @Override
    public Prescriptions addPrescription (PrescriptionsDTO prescriptionsDTO) {
        Doctors doctor = doctorsRepository.findById(
                        prescriptionsDTO.getDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Không tìm thấy bác sĩ có ID "
                                + prescriptionsDTO.getDoctorId()
                ));

        Patients patient = patientsRepository.findById(
                        prescriptionsDTO.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Không tìm thấy bệnh nhân có ID"
                                + prescriptionsDTO.getPatientId()
                ));

        Prescriptions prescription = Prescriptions.builder()
                .diagnosis(prescriptionsDTO.getDiagnosis())
                .createdAt(prescriptionsDTO.getCreatedAt())
                .doctor(doctor)
                .patient(patient)
                .build();

        return prescriptionsRepository.save(prescription);
    }
}
