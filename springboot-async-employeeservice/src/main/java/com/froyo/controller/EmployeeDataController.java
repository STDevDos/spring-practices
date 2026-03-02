package com.froyo.controller;

import com.froyo.model.EmployeeAddresses;
import com.froyo.model.EmployeeNames;
import com.froyo.model.EmployeePhone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeDataController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeDataController.class);

    @GetMapping("/name")
    public EmployeeNames getEmployeeName() {
        log.info("getEmployeeName...");
        EmployeeNames employeeNames = new EmployeeNames();
        employeeNames.setEmployeeNameList(new ArrayList<>());
        return employeeNames;
    }

    @GetMapping("/address")
    public EmployeeAddresses getEmployeeAddress() {
        log.info("getEmployeeAddress...");
        EmployeeAddresses employeeAddresses = new EmployeeAddresses();
        employeeAddresses.setEmployeeAddressList(new ArrayList<>());
        return employeeAddresses;
    }

    @GetMapping("/phone")
    public EmployeePhone getEmployeePhone() {
        log.info("getEmployeePhone...");
        EmployeePhone employeePhone = new EmployeePhone();
        employeePhone.setPhoneNumbers(new ArrayList<>());
        return employeePhone;
    }

}
