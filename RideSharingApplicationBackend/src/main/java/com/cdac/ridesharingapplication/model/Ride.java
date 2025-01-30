package com.cdac.ridesharingapplication.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Author: Admin
* Date: 30 Jan 2025
**/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ride {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne(cascade = CascadeType.ALL)
	    private User user;

	    @ManyToOne(cascade = CascadeType.ALL)
	    private Driver driver;

	    @JsonIgnore
	    private List<Long> declinedDrivers = new ArrayList<>();

	    private Double pickupLatitude;
	    private Double pickupLongitude;
	    private Double destinationLatitude;
	    private Double destinationLongitude;

	    private String pickupArea;
	    private String destinationArea;

	    private Double distance;
	    private Long duration;

	    //private RideStatus status;

	    private LocalDateTime startTime;
	    private LocalDateTime endTime;

	    private Double fare;
	    private Integer otp;
}
