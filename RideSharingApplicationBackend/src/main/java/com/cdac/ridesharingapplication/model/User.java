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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String fullName;
	    private String email;
	    private String mobile;
	    private String password;
	    private String profilePicture;
	    //private UserRole role;
	    
	  @JsonIgnore
	    @OneToOne(cascade = CascadeType.ALL)
	    private Ride currentRide;
}
