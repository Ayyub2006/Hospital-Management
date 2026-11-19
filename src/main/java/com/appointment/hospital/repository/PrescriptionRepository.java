package com.appointment.hospital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointment.hospital.entity.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription,  Long>{
	Optional<Prescription> findByAppointmentId(Long appointmentId);

}
