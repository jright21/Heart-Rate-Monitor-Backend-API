package com.healthcare.pulsemonitor.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name = "heart_rate_records")
public class HeartRateRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)  // ✅ FIX: Fetch full Patient object
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    private int heartRate;
    private LocalDateTime timestamp = LocalDateTime.now();
}
