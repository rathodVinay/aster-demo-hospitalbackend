package com.example.Aster_Hosp.DTO;

// DoctorRequest.java

import lombok.Data;

@Data
public class DoctorRequest {
    private String name;
    private String specialty;
    private String phone;
    private String email;
    // Getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

