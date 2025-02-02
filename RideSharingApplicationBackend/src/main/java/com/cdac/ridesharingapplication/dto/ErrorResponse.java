package com.cdac.ridesharingapplication.dto;

public class ErrorResponse {
    private String message;
    private boolean success;
    
    // Default constructor
    public ErrorResponse() {
    }
    
    // Constructor with parameters
    public ErrorResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
    
    // Getters and Setters
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public boolean isSuccess() {
        return success;
    }
    
    public void setSuccess(boolean success) {
        this.success = success;
    }
}
