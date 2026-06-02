package com.example.hospitalmanagement.repository;

import com.example.hospitalmanagement.models.entity.Meetings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingsRepository extends JpaRepository<Meetings, Integer> {
    List<Meetings> getMeetingsByDoctorId(Integer doctorId);
}
