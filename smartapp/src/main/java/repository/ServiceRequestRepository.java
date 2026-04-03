package com.project.smartapp.repository;

import com.project.smartapp.entity.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {

    // ADD THIS METHOD
    List<ServiceRequest> findByStatus(String status);
    List<ServiceRequest> findByLocation(String location);
    long countByStatus(String status);
}