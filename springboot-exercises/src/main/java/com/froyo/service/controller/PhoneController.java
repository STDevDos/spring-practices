package com.froyo.service.controller;

import com.froyo.service.services.PhoneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneController {

    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/getPhones")
    public List<String> getPhones() {
        return phoneService.getPhones();
    }

}
