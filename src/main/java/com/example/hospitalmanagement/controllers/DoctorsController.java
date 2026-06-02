package com.example.hospitalmanagement.controllers;

import com.example.hospitalmanagement.models.dto.request.DoctorDTO;
import com.example.hospitalmanagement.models.dto.request.MeetingsDTO;
import com.example.hospitalmanagement.models.dto.response.ApiResponse;
import com.example.hospitalmanagement.models.entity.Doctors;
import com.example.hospitalmanagement.models.entity.Meetings;
import com.example.hospitalmanagement.service.DoctorsService;
import com.example.hospitalmanagement.service.MeetingsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorsController {
    private final DoctorsService doctorsService;
    private final MeetingsService meetingsService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Doctors>>> getAllDoctors() {

        List<Doctors> doctorsList = doctorsService.getAllDoctors();

        ApiResponse.Meta meta = new ApiResponse.Meta(doctorsList.size(), 1);

        ApiResponse<List<Doctors>> apiResponse = new ApiResponse<>(
                true,
                200,
                doctorsList,
                meta
        );

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Doctors getDoctorById(@PathVariable("id") Integer id){
        return doctorsService.getDoctorById(id);
    }

    @PostMapping
    public Doctors addDoctor(@Valid @RequestBody DoctorDTO doctorDTO) {
        return doctorsService.addDoctor(doctorDTO);
    }

    @PutMapping("/{id}")
    public Doctors editDoctor(@PathVariable("id") Integer id, @Valid @RequestBody DoctorDTO newDoctorDTO) {
        return doctorsService.editDoctor(id, newDoctorDTO);
    }

    @PatchMapping("/{id}")
    public Doctors patchDoctor(@PathVariable("id") Integer id, @Valid @ModelAttribute DoctorDTO newDoctorDTO) {
        return doctorsService.patchDoctor(id, newDoctorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable("id") Integer id) {
        doctorsService.deleteDoctor(id);
        System.out.println("Đã xóa thành công");
    }

    @GetMapping("/{doctorId}/meetings")
    public ResponseEntity<ApiResponse<List<Meetings>>> getMeetingsByDoctorId(
            @PathVariable("doctorId") Integer doctorId) {
        List<Meetings> meetingsByDoctorId = meetingsService.getMeetingsByDoctorId(doctorId);

        ApiResponse.Meta meta = new ApiResponse.Meta(meetingsByDoctorId.size(), 1);

        ApiResponse<List<Meetings>> apiResponse = new ApiResponse<>(
                true,
                200,
                meetingsByDoctorId,
                meta
        );

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/{doctorId}/meetings")
    public Meetings addMeeting(
            @PathVariable("doctorId") Integer doctorId,
            @Valid @RequestBody MeetingsDTO meetingsDTO) {
        return meetingsService.addMeeting(meetingsDTO);
    }
}
