package com.appointment.hospital.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;

import com.appointment.hospital.enums.AppointmentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "appointments", uniqueConstraints = @UniqueConstraint(
		name = "uk_active_slot",
		columnNames = {"doctor_id", "appointment_date", "start_time", "active_slot"}),
		
		indexes = {
				@Index(name = "idx_appt_patient", columnList = "patient id"),
				@Index(name = "idx_appt_doctor_date", columnList = "doctor_id, appointment_date")
		})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "appointment_date", nullable = false)
	private LocalDate appointmentDate;
	
	@Column(name = "start_time", nullable = false)
	private LocalTime startTime;
	
	@Column(name = "end_time", nullable = false)
	private LocalTime endTime;
	
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private AppointmentStatus status;
	
	@Column(length = 500)
	private String reason;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "doctor_id", nullable = false)
	private DoctorProfile doctor;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "patient_id", nullable = false)
	private User patient;
	

    /** 1 while BOOKED, NULL otherwise. Used only by the unique constraint. */
	@Column(name = "active_slot")
	private Integer activeSlot;
	
	/** Optimistic locking: Hibernate adds "WHERE version = ?" to every UPDATE. */
	@Version
	private Long version;
	
	
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;
	
	@PrePersist
	@PreUpdate
	
	void syncActiveSlot() {
		this.activeSlot = (status == AppointmentStatus.BOOKED) ? 1 : null;
	}
	
}
