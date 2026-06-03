Phần API sau khi đã được thêm log:


public Patients addPatient (PatientsDTO patientsDTO){
log.info("Có yêu cầu thêm bệnh nhân {}", patientsDTO.getFullName());

        int minus = Period.between(patientsDTO.getDob(), LocalDate.now()).getYears();

        if (minus > 120) {
            log.warn("Số tuổi bệnh nhân quá cao {}", minus);
        }

        Patients patient = Patients.builder()
                .fullName(patientsDTO.getFullName())
                .phoneNumber(patientsDTO.getPhoneNumber())
                .dob(patientsDTO.getDob())
                .gender(patientsDTO.getGender())
                .address(patientsDTO.getAddress())
                .build();

        Patients savedPatient = patientsRepository.save(patient);

        log.info("Bệnh nhân {} được thêm vào với id {}",
                savedPatient.getFullName(),
                savedPatient.getId());

        return savedPatient;
    }