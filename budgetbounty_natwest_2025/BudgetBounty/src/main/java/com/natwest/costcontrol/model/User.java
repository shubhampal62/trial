package com.natwest.costcontrol.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true, length = 200)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "registered_at", nullable = false)
    private LocalDateTime registeredAt;

    @Column(length = 20)
    private String pan;

    @Column(name = "app_admin", nullable = false)
    private boolean appAdmin = false;

    @Column(nullable = false)
    private int points = 0;

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

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
