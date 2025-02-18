package com.healthcare.pulsemonitor.service;

import com.healthcare.pulsemonitor.model.Patient;
import com.healthcare.pulsemonitor.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }
}
