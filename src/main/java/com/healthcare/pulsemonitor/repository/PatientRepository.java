package com.healthcare.pulsemonitor.repository;

import com.healthcare.pulsemonitor.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
