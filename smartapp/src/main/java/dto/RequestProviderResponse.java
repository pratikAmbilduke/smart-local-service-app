package com.project.smartapp.dto;

import com.project.smartapp.entity.Provider;
import com.project.smartapp.entity.ServiceRequest;

public class RequestProviderResponse {

    private ServiceRequest request;
    private Provider provider;

    public RequestProviderResponse() {
    }

    public RequestProviderResponse(ServiceRequest request, Provider provider) {
        this.request = request;
        this.provider = provider;
    }

    public ServiceRequest getRequest() {
        return request;
    }

    public void setRequest(ServiceRequest request) {
        this.request = request;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}