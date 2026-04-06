package com.project.smartapp.controller;

import com.project.smartapp.entity.Provider;
import com.project.smartapp.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/provider")
public class ProviderController {

    @Autowired
    private ProviderRepository repository;

    @PostMapping("/create")
    public Provider createProvider(@RequestBody Provider provider) {
        return repository.save(provider);
    }

    @GetMapping("/all")
    public List<Provider> getAllProviders() {
        return repository.findAll();
    }

    @GetMapping("/service/{serviceType}")
    public List<Provider> getProvidersByServiceType(@PathVariable String serviceType) {
        return repository.findByServiceType(serviceType);
    }

    @GetMapping("/status/{status}")
    public List<Provider> getProvidersByStatus(@PathVariable String status) {
        return repository.findByStatus(status);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProvider(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Deleted successfully";
        } else {
            return "Provider not found";
        }
    }

    @PutMapping("/update/{id}")
    public Provider updateProvider(@PathVariable Long id, @RequestBody Provider updatedProvider) {
        Provider existingProvider = repository.findById(id).orElse(null);

        if (existingProvider != null) {
            existingProvider.setName(updatedProvider.getName());
            existingProvider.setServiceType(updatedProvider.getServiceType());
            existingProvider.setPhone(updatedProvider.getPhone());
            existingProvider.setStatus(updatedProvider.getStatus());

            return repository.save(existingProvider);
        }

        return null;
    }
}