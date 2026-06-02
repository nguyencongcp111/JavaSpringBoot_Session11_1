package com.example.hospitalmanagement.service.impl;

import com.example.hospitalmanagement.exception.InvalidInputException;
import com.example.hospitalmanagement.exception.ResourceNotFoundException;
import com.example.hospitalmanagement.models.dto.request.DoctorDTO;
import com.example.hospitalmanagement.models.entity.Doctors;
import com.example.hospitalmanagement.models.entity.Gender;
import com.example.hospitalmanagement.repository.DoctorsRepository;
import com.example.hospitalmanagement.service.DoctorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorsServiceImpl implements DoctorsService {
    private final DoctorsRepository doctorsRepository;

    @Override
    public List<Doctors> getAllDoctors(){
        return doctorsRepository.findAll();
    }

    @Override
    public Doctors getDoctorById(Integer id) {
        return doctorsRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Không tìm thấy bác sĩ có id: " + id));
    }

    @Override
    public Doctors addDoctor(DoctorDTO doctorDTO) {

        if (doctorDTO.getDob() != null && doctorDTO.getDob().isAfter(LocalDate.now())) {
            throw new InvalidInputException("Ngày sinh không thể sau " + LocalDate.now());
        }

        if (doctorDTO.getGender() != null
                && !doctorDTO.getGender().equals(Gender.MALE)
                && !doctorDTO.getGender().equals(Gender.FEMALE)
                && !doctorDTO.getGender().equals(Gender.OTHER)) {
            throw new InvalidInputException("Để nhập đúng giới tính, vui lòng nhập như sau:" +
                    "Nam = MALE, Nữ = FEMALE, Khác = OTHER");
        }

        Doctors doctor = Doctors.builder()
                .fullName(doctorDTO.getFullName())
                .email(doctorDTO.getEmail())
                .phoneNumber(doctorDTO.getPhoneNumber())
                .gender(doctorDTO.getGender())
                .dob(doctorDTO.getDob())
                .specialization(doctorDTO.getSpecialization())
                .build();

        return doctorsRepository.save(doctor);
    }

    @Override
    public Doctors editDoctor(Integer id, DoctorDTO newDoctorDTO) {
        Doctors doctor = doctorsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Không tìm thấy id bác sĩ"));

        if (newDoctorDTO.getDob() != null && newDoctorDTO.getDob().isAfter(LocalDate.now())) {
            throw new InvalidInputException("Ngày sinh không thể sau " + LocalDate.now());
        }

        if (newDoctorDTO.getGender() != null
                && !newDoctorDTO.getGender().equals(Gender.MALE)
                && !newDoctorDTO.getGender().equals(Gender.FEMALE)
                && !newDoctorDTO.getGender().equals(Gender.OTHER)) {
            throw new InvalidInputException("Để nhập đúng giới tính, vui lòng nhập như sau:" +
                    "Nam = MALE, Nữ = FEMALE, Khác = OTHER");
        }

        doctor.setFullName(newDoctorDTO.getFullName());
        doctor.setEmail(newDoctorDTO.getEmail());
        doctor.setPhoneNumber(newDoctorDTO.getPhoneNumber());
        doctor.setGender(newDoctorDTO.getGender());
        doctor.setDob(newDoctorDTO.getDob());
        doctor.setSpecialization(newDoctorDTO.getSpecialization());

        return doctorsRepository.save(doctor);
    }

    @Override
    public Doctors patchDoctor(Integer id, DoctorDTO newDoctorDTO) {
        Doctors doctor = doctorsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Không tìm thấy id bác sĩ"));

        if (newDoctorDTO.getDob() != null && newDoctorDTO.getDob().isAfter(LocalDate.now())) {
            throw new InvalidInputException("Ngày sinh không thể sau " + LocalDate.now());
        }

        if (newDoctorDTO.getGender() != null
                && !newDoctorDTO.getGender().equals(Gender.MALE)
                && !newDoctorDTO.getGender().equals(Gender.FEMALE)
                && !newDoctorDTO.getGender().equals(Gender.OTHER)) {
            throw new InvalidInputException("Để nhập đúng giới tính, vui lòng nhập như sau:" +
                    "Nam = MALE, Nữ = FEMALE, Khác = OTHER");
        }

        if (newDoctorDTO.getFullName() != null && !newDoctorDTO.getFullName().isEmpty()) {
            doctor.setFullName(newDoctorDTO.getFullName());
        }
        if (newDoctorDTO.getEmail() != null && !newDoctorDTO.getEmail().isEmpty()) {
            doctor.setEmail(newDoctorDTO.getEmail());
        }
        if (newDoctorDTO.getPhoneNumber() != null && !newDoctorDTO.getPhoneNumber().isEmpty()) {
            doctor.setPhoneNumber(newDoctorDTO.getPhoneNumber());
        }
        if (newDoctorDTO.getGender() != null) {
            doctor.setGender(newDoctorDTO.getGender());
        }
        if (newDoctorDTO.getDob() != null) {
            doctor.setDob(newDoctorDTO.getDob());
        }
        if (newDoctorDTO.getSpecialization() != null && !newDoctorDTO.getSpecialization().isEmpty()) {
            doctor.setSpecialization(newDoctorDTO.getSpecialization());
        }

        return doctorsRepository.save(doctor);
    }

    @Override
    public void deleteDoctor(Integer id) {
        Doctors doctor = doctorsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Không tìm thấy id bác sĩ"));

        doctorsRepository.delete(doctor);
    }
}
