package com.froyo.service.services.impl;

import com.froyo.service.model.User;
import com.froyo.service.repository.h2.JDBCH2Repository;
import com.froyo.service.services.JDBCH2Service;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JDBCH2ServiceImpl implements JDBCH2Service {

    private final JDBCH2Repository jdbcH2Repository;

    public JDBCH2ServiceImpl(JDBCH2Repository jdbcH2Repository) {
        this.jdbcH2Repository = jdbcH2Repository;
    }

    @Override
    public void save(User user) {
        jdbcH2Repository.save(user);
    }

    @Override
    public List<User> findAll() {
        return jdbcH2Repository.findAll();
    }
}
