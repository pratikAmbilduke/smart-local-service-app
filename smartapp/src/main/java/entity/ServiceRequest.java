package com.project.smartapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "service_requests")
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceType; // plumber, electrician
    private String location;
    private String status; // PENDING, ACCEPTED, COMPLETED

    // Constructor
    public ServiceRequest() {}

    public ServiceRequest(String serviceType, String location, String status) {
        this.serviceType = serviceType;
        this.location = location;
        this.status = status;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}