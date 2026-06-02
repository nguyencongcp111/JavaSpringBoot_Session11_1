package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.models.dto.request.MeetingsDTO;
import com.example.hospitalmanagement.models.entity.Meetings;

import java.util.List;

public interface MeetingsService {
    List<Meetings> getMeetingsByDoctorId(Integer doctorId);

    Meetings addMeeting (MeetingsDTO meetingsDTO);
}
