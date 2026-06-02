package com.example.hospitalmanagement.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "meetings")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Meetings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meeting_id")
    private Integer id;
    @Column(name = "appointment_time")
    private LocalDateTime appointmentTime;
    @Column(name = "reason")
    private String reason;
    @Column(name = "status")
    private MeetingStatus status;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctors doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patients patient;
}
