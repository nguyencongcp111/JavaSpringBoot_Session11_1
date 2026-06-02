package com.example.hospitalmanagement.controllers;

import com.example.hospitalmanagement.models.dto.request.PatientsDTO;
import com.example.hospitalmanagement.models.dto.request.PrescriptionsDTO;
import com.example.hospitalmanagement.models.entity.Patients;
import com.example.hospitalmanagement.models.entity.Prescriptions;
import com.example.hospitalmanagement.service.PatientsService;
import com.example.hospitalmanagement.service.PrescriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientsController {
    private final PatientsService patientsService;
    private final PrescriptionService prescriptionService;

    @GetMapping
    public List<Patients> getAllPatients() {
        return patientsService.getAllPatients();
    }

    @PostMapping
    public Patients addPatient(@Valid @RequestBody PatientsDTO patientsDTO) {
        return patientsService.addPatient(patientsDTO);
    }

    @GetMapping("/{patientId}/prescriptions/{prescriptionId}")
    public Prescriptions getPrescriptionByPrescriptionIdByPatientId(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("prescriptionId") Integer prescriptionId) {
        return prescriptionService.getPrescriptionByIdAndPatientId(patientId, prescriptionId);
    }

    @PostMapping("/{patientId}/prescriptions")
    public Prescriptions addPrescription (
            @PathVariable("patientId") Integer patientId,
            @Valid @RequestBody PrescriptionsDTO prescriptionsDTO) {
        return prescriptionService.addPrescription(prescriptionsDTO);
    }
}
