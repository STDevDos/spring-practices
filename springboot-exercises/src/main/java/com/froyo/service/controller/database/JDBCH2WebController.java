package com.froyo.service.controller.database;

import com.froyo.service.model.User;
import com.froyo.service.services.JDBCH2Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JDBCH2WebController {

    private final JDBCH2Service jdbcH2Service;

    public JDBCH2WebController(JDBCH2Service jdbcH2Service) {
        this.jdbcH2Service = jdbcH2Service;
    }

    @PostMapping("/saveUserH2")
    public String saveUserH2(@RequestBody User user) {
        jdbcH2Service.save(user);
        return "success";
    }

    @GetMapping("/findAllH2")
    public List<User> findAllH2() {
        return jdbcH2Service.findAll();
    }
}
