package com.healthcare.pulsemonitor.service;

import com.healthcare.pulsemonitor.model.HeartRateRecord;
import com.healthcare.pulsemonitor.model.Patient;
import com.healthcare.pulsemonitor.repository.HeartRateRecordRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HeartRateService {
    private final HeartRateRecordRepository heartRateRecordRepository;

    public HeartRateService(HeartRateRecordRepository heartRateRecordRepository) {
        this.heartRateRecordRepository = heartRateRecordRepository;
    }

    public HeartRateRecord saveHeartRate(HeartRateRecord record) {
        return heartRateRecordRepository.save(record);
    }

    // ✅ FIX: Add missing method
    public Optional<HeartRateRecord> getHeartRateByPatient(Patient patient) {
        return heartRateRecordRepository.findByPatient(patient);
    }
}
