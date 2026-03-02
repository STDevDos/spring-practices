package com.froyo.scopeannotation.controller;

import com.froyo.scopeannotation.bean.Address;
import com.froyo.scopeannotation.bean.Age;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {

    private final Age age;
    private final Address address;

    public HomeRestController(Age age, Address address) {
        this.age = age;
        this.address = address;
    }

    @GetMapping("/age")
    public int getAge() {
        return age.getAge();
    }

    @GetMapping("/address")
    public String getAddress() {
        return address.getAddress();
    }

}
