package com.api.parkingcontrol.dtos.v2;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class RegisterDto {

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private String years;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }
}
