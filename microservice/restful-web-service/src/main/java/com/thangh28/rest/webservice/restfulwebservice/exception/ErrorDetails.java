package com.thangh28.rest.webservice.restfulwebservice.exception;

import java.time.LocalDate;

public class ErrorDetails {
    private LocalDate timestamp;
    private String mesage;
    private String details;

    public ErrorDetails(LocalDate timestamp, String mesage, String details) {
        this.timestamp = timestamp;
        this.mesage = mesage;
        this.details = details;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
