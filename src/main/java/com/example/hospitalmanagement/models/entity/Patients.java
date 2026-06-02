package com.example.hospitalmanagement.models.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patients")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "dob")
    private LocalDate dob;
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Meetings> meetings;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Prescriptions> prescriptions;
}
