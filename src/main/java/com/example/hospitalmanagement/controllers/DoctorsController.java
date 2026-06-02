package com.example.hospitalmanagement.controllers;

import com.example.hospitalmanagement.models.dto.request.DoctorDTO;
import com.example.hospitalmanagement.models.entity.Doctors;
import com.example.hospitalmanagement.service.DoctorsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorsController {
    private final DoctorsService doctorsService;

    @GetMapping
    public List<Doctors> getAllDoctors() {
        return doctorsService.getAllDoctors();
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
}
