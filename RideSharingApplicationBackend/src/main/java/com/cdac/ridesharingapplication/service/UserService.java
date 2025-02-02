package com.cdac.ridesharingapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cdac.ridesharingapplication.dto.AuthResponse;
import com.cdac.ridesharingapplication.dto.LoginDTO;
import com.cdac.ridesharingapplication.dto.UserDTO;
import com.cdac.ridesharingapplication.exception.CustomException;
import com.cdac.ridesharingapplication.model.User;
import com.cdac.ridesharingapplication.repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public AuthResponse registerUser(UserDTO userDTO) {
        if(userRepository.existsByEmail(userDTO.getEmail())) {
            throw new CustomException("Email already registered!", HttpStatus.CONFLICT);
        }
        
        if(userRepository.existsByMobile(userDTO.getMobile())) {
            throw new CustomException("Mobile number already registered!", HttpStatus.CONFLICT);
        }
        
        User user = new User();
        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        user.setMobile(userDTO.getMobile());
        user.setPassword(userDTO.getPassword()); // Should be encrypted in production
        user.setProfilePicture(userDTO.getProfilePicture());
        
        User savedUser = userRepository.save(user);
        
        return new AuthResponse(
            "User registered successfully",
            true,
            "dummy-token", // Replace with actual JWT token
            savedUser
        );
    }
    
    public AuthResponse loginUser(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getEmail())
            .orElseThrow(() -> new CustomException("User not found!", HttpStatus.UNAUTHORIZED));
        
        if(!user.getPassword().equals(loginDTO.getPassword())) {
            throw new CustomException("Invalid credentials!", HttpStatus.UNAUTHORIZED);
        }
        
        return new AuthResponse(
            "Login successful",
            true,
            "dummy-token", // Replace with actual JWT token
            user
        );
    }
}
