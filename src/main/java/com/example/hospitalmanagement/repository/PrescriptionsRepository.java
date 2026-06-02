package com.example.hospitalmanagement.repository;

import com.example.hospitalmanagement.models.entity.Prescriptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrescriptionsRepository extends JpaRepository<Prescriptions, Integer> {
    Optional<Prescriptions> getPrescriptionByIdAndPatientId(
            Integer patientId, Integer prescriptionId);
}
