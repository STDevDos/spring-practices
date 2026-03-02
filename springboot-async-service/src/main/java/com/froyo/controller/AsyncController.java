package com.froyo.controller;

import com.froyo.model.EmployeeAddresses;
import com.froyo.model.EmployeeNames;
import com.froyo.model.EmployeePhone;
import com.froyo.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class AsyncController {

    private static final Logger log = LoggerFactory.getLogger(AsyncController.class);

    private final AsyncService service;

    public AsyncController(AsyncService service) {
        this.service = service;
    }

    @GetMapping("/testAsync")
    public void testAsync() throws InterruptedException, ExecutionException {
        log.info("testAsync Start");

        CompletableFuture<EmployeeNames> employeeName = service.getEmployeeName();
        CompletableFuture<EmployeeAddresses> employeeAddress = service.getEmployeeAddress();
        CompletableFuture<EmployeePhone> employeePhone = service.getEmployeePhone();

        // Wait until they are all done
        CompletableFuture.allOf(employeeName, employeeAddress, employeePhone).join();

        log.info("EmployeeName--> " + employeeName.get());
        log.info("EmployeeAddress--> " + employeeAddress.get());
        log.info("EmployeePhone--> " + employeePhone.get());
    }

}
