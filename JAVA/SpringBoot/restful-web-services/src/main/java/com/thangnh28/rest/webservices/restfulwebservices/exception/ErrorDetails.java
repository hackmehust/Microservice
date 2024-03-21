package com.thangnh28.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
    private LocalDateTime timestramp;
    private String message;
    private String details;

    public ErrorDetails(LocalDateTime timestramp, String message, String details) {
        this.timestramp = timestramp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimestramp() {
        return timestramp;
    }

    public void setTimestramp(LocalDateTime timestramp) {
        this.timestramp = timestramp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
