package com.project.smartapp.controller;

import com.project.smartapp.entity.ServiceRequest;
import com.project.smartapp.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("/api/service")
public class ServiceRequestController {

    @Autowired
    private ServiceRequestRepository repository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @PostMapping("/create")
    public ServiceRequest createRequest(@RequestBody ServiceRequest request) {
        request.setStatus("PENDING");
        ServiceRequest saved = repository.save(request);
        messagingTemplate.convertAndSend("/topic/requests", saved);
        return saved;
    }

    @GetMapping("/all")
    public List<ServiceRequest> getAllRequests() {
        return repository.findAll();
    }

    @GetMapping("/pending")
    public List<ServiceRequest> getPendingRequests() {
        return repository.findByStatus("PENDING");
    }

    @PutMapping("/accept/{id}")
    public ServiceRequest acceptRequest(@PathVariable Long id) {
        ServiceRequest request = repository.findById(id).orElse(null);

        if (request != null) {
            request.setStatus("ACCEPTED");
            ServiceRequest updated = repository.save(request);
            messagingTemplate.convertAndSend("/topic/requests", updated);
            return updated;
        }

        return null;
    }
    @DeleteMapping("/delete/{id}")
    public String deleteRequest(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Deleted successfully";
        } else {
            return "Request not found";
        }
    }
    @PutMapping("/update/{id}")
    public ServiceRequest updateRequest(@PathVariable Long id, @RequestBody ServiceRequest updatedRequest) {
        ServiceRequest existingRequest = repository.findById(id).orElse(null);

        if (existingRequest != null) {
            existingRequest.setServiceType(updatedRequest.getServiceType());
            existingRequest.setLocation(updatedRequest.getLocation());
            existingRequest.setLatitude(updatedRequest.getLatitude());
            existingRequest.setLongitude(updatedRequest.getLongitude());
            existingRequest.setStatus(updatedRequest.getStatus());

            return repository.save(existingRequest);
        }

        return null;
    }

    @PutMapping("/complete/{id}")
    public ServiceRequest completeRequest(@PathVariable Long id) {
        ServiceRequest request = repository.findById(id).orElse(null);

        if (request != null) {
            request.setStatus("COMPLETED");
            ServiceRequest updated = repository.save(request);
            messagingTemplate.convertAndSend("/topic/requests", updated);
            return updated;
        }

        return null;
    }
}