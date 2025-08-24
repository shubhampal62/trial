package com.natwest.costcontrol.dto;

import java.time.LocalDateTime;

public class UserResponseDTO {
	private Long userId;
	private String name;
	private String email;
	private LocalDateTime registeredAt;
	private String pan;
	private boolean appAdmin;
	private int points;

	// Getters and Setters
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(LocalDateTime registeredAt) {
		this.registeredAt = registeredAt;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public boolean isAppAdmin() {
		return appAdmin;
	}

	public void setAppAdmin(boolean appAdmin) {
		this.appAdmin = appAdmin;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
