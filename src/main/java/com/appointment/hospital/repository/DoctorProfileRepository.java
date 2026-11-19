package com.appointment.hospital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointment.hospital.entity.DoctorProfile;

public interface DoctorProfileRepository extends JpaRepository<DoctorProfile, Long>{
	
	Optional<DoctorProfile> findByUserId(Long userId);

}
