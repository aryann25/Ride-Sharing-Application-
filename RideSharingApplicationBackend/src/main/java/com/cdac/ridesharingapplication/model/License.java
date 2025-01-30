package com.cdac.ridesharingapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Author: Admin
* Date: 30 Jan 2025
**/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String licenseNumber;
    private String licenseState;
    private String licenseExpirationDate;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Driver driver;
}
