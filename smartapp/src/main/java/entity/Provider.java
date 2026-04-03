package com.project.smartapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "providers")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String serviceType;
    private String phone;
    private String status;

    public Provider() {
    }

    public Provider(String name, String serviceType, String phone, String status) {
        this.name = name;
        this.serviceType = serviceType;
        this.phone = phone;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getPhone() {
        return phone;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}