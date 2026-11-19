package com.appointment.hospital.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointment.hospital.entity.Appointment;
import com.appointment.hospital.enums.AppointmentStatus;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

	List<Appointment> findByDoctorIdAndAppointmentDateAndStatus(
			Long doctorId, LocalDate date, AppointmentStatus status);
	
	List<Appointment> findByPatientIdOrderByAppointmentDateDesc(Long pateientId);
}
