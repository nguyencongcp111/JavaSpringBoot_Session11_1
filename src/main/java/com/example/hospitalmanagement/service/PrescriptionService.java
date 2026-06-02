package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.models.dto.request.PrescriptionsDTO;
import com.example.hospitalmanagement.models.entity.Prescriptions;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PrescriptionService {
    Prescriptions getPrescriptionByIdAndPatientId
            (Integer patientId, Integer prescriptionId);

    Prescriptions addPrescription (PrescriptionsDTO prescriptionsDTO);
}
