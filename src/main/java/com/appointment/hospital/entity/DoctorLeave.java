package com.appointment.hospital.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctor_leaves",
       uniqueConstraints = @UniqueConstraint(
           name = "uk_doctor_leave_date",
           columnNames = {"doctor_id", "leave_date"}))
@Getter 
@Setter
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class DoctorLeave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "leave_date", nullable = false)
	private LocalDate leaveDate;
	
	@Column(length = 255)
	private String reason;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "doctor_id", nullable = false)
	private DoctorProfile doctor;
}
