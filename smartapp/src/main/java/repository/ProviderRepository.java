package com.project.smartapp.repository;

import com.project.smartapp.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

    List<Provider> findByServiceType(String serviceType);

    List<Provider> findByStatus(String status);

    Optional<Provider> findFirstByServiceTypeAndStatus(String serviceType, String status);
}