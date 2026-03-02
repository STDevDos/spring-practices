package com.froyo.service;

import com.froyo.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    private final RestTemplate restTemplate;

    public AsyncService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Async("asyncExecutor")
    public CompletableFuture<EmployeeNames> getEmployeeName() throws InterruptedException {
        EmployeeNames inventory = restTemplate.getForObject("http://localhost:8080/name", EmployeeNames.class);
        return CompletableFuture.completedFuture(inventory);
    }

    @Async("asyncExecutor")
    public CompletableFuture<EmployeeAddresses> getEmployeeAddress() throws InterruptedException {
        EmployeeAddresses inventory = restTemplate.getForObject("http://localhost:8080/address",
                EmployeeAddresses.class);
        return CompletableFuture.completedFuture(inventory);
    }

    @Async("asyncExecutor")
    public CompletableFuture<EmployeePhone> getEmployeePhone() throws InterruptedException {
        EmployeePhone inventory = restTemplate.getForObject("http://localhost:8080/phone", EmployeePhone.class);
        return CompletableFuture.completedFuture(inventory);
    }

}
