package com.example.hospitalmanagement.repository;

import com.example.hospitalmanagement.models.entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepository extends JpaRepository<Patients, Integer> {
}
