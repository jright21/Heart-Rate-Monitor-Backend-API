package com.healthcare.pulsemonitor.controller;

import com.healthcare.pulsemonitor.model.HeartRateRecord;
import com.healthcare.pulsemonitor.model.Patient;
import com.healthcare.pulsemonitor.service.HeartRateService;
import com.healthcare.pulsemonitor.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/heart-rate")
public class HeartRateController {
    private final HeartRateService heartRateService;
    private final PatientService patientService;

    public HeartRateController(HeartRateService heartRateService, PatientService patientService) {
        this.heartRateService = heartRateService;
        this.patientService = patientService;
    }

    @PostMapping("/add")
    public HeartRateRecord addHeartRate(@RequestBody HeartRateRecord record) {
        // ✅ FIX: Fetch the full Patient object using the patient ID
        Optional<Patient> patient = patientService.getPatientById(record.getPatient().getId());
        
        if (patient.isEmpty()) {
            throw new RuntimeException("Patient ID not found: " + record.getPatient().getId());
        }
        
        record.setPatient(patient.get());  // ✅ Assign full Patient object
        return heartRateService.saveHeartRate(record);
    }

    @GetMapping("/patient/{id}")
    public Optional<HeartRateRecord> getHeartRateByPatient(@PathVariable Long id) {
        Optional<Patient> patient = patientService.getPatientById(id);
        
        if (patient.isEmpty()) {
            throw new RuntimeException("Patient ID not found: " + id);
        }
        
        return heartRateService.getHeartRateByPatient(patient.get());
    }
}
