package com.appointment.hospital.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointment.hospital.entity.DoctorLeave;

public interface DoctorLeaveRepository extends JpaRepository<DoctorLeave, Long>{
	
	boolean existsByDoctorIdAndLeaveDate(Long doctorId, LocalDate leavedate);

}
