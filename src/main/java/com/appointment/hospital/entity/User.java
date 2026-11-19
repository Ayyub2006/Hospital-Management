package com.appointment.hospital.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.appointment.hospital.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100, unique = true)
	private String email;
	
	@Column(nullable = false, length = 150)
	private String name;
	
	@Column(name = "password_hash", nullable = false)
	private String passwordHash;
	
	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(length = 20)
	private String phone;
	
	@Column(nullable = false)
	@Builder.Default
	private boolean active = true;
	
	
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;
}
