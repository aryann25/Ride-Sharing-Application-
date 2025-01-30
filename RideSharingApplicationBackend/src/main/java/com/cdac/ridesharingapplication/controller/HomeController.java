package com.cdac.ridesharingapplication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* Author: Admin
* Date: 30 Jan 2025
**/
@RestController
@RequestMapping("/home")
public class HomeController {
	public String home()
	{
		return "Welcome to Ride Sharing Application";
	}
}
