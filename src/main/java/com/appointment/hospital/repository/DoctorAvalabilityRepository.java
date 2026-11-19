package com.appointment.hospital.repository;

import java.time.DayOfWeek;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointment.hospital.entity.DoctorAvalability;

public interface DoctorAvalabilityRepository extends JpaRepository<DoctorAvalability, Long>{
	
	List<DoctorAvalability> findByDoctorIdAndDayOfWeek(Long doctorId, DayOfWeek dayOfWeek);
	List<DoctorAvalability> findDoctorById(Long DoctorId);

	
}
