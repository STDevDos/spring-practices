package com.froyo.service.services.impl;

import com.froyo.service.services.PhoneService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {
    @Override
    public List<String> getPhones() {
        return Arrays.asList("123456789", "987654321");
    }
}
