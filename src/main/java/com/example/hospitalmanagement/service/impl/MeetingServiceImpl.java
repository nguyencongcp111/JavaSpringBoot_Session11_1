package com.example.hospitalmanagement.service.impl;

import com.example.hospitalmanagement.exception.ResourceNotFoundException;
import com.example.hospitalmanagement.models.dto.request.MeetingsDTO;
import com.example.hospitalmanagement.models.entity.Doctors;
import com.example.hospitalmanagement.models.entity.Meetings;
import com.example.hospitalmanagement.models.entity.Patients;
import com.example.hospitalmanagement.repository.DoctorsRepository;
import com.example.hospitalmanagement.repository.MeetingsRepository;
import com.example.hospitalmanagement.repository.PatientsRepository;
import com.example.hospitalmanagement.service.MeetingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingServiceImpl implements MeetingsService {
    private final MeetingsRepository meetingsRepository;
    private final DoctorsRepository doctorsRepository;
    private final PatientsRepository patientsRepository;

    @Override
    public List<Meetings> getMeetingsByDoctorId(Integer doctorId) {
        Doctors doctor = doctorsRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Không tìm thấy bác sĩ có ID "
                                + doctorId
                ));

        return meetingsRepository.getMeetingsByDoctorId(doctorId);
    }

    @Override
    public Meetings addMeeting (MeetingsDTO meetingsDTO) {
        Doctors doctor = doctorsRepository.findById(
                meetingsDTO.getDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException(
                "Không tìm thấy bác sĩ có ID "
                + meetingsDTO.getDoctorId()
        ));

        Patients patient = patientsRepository.findById(
                meetingsDTO.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Không tìm thấy bệnh nhân có ID"
                        + meetingsDTO.getPatientId()
                ));

        Meetings meeting = Meetings.builder()
                .appointmentTime(meetingsDTO.getAppointmentTime())
                .reason(meetingsDTO.getReason())
                .status(meetingsDTO.getStatus())
                .doctor(doctor)
                .patient(patient)
                .build();

        return meetingsRepository.save(meeting);
    }
}
