package com.appointment.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointment.hospital.entity.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Long>{

	boolean existsByNameIgnoreCase(String name);
}
