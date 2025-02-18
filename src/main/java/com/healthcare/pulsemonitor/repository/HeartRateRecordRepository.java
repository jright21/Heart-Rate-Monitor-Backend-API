package com.healthcare.pulsemonitor.repository;

import com.healthcare.pulsemonitor.model.HeartRateRecord;
import com.healthcare.pulsemonitor.model.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HeartRateRecordRepository extends JpaRepository<HeartRateRecord, Long> {
    Optional<HeartRateRecord> findByPatient(Patient patientId);
}
