package com.froyo.service.repository.h2.impl;

import com.froyo.service.model.User;
import com.froyo.service.repository.h2.JDBCH2Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JDBCH2RepositoryImpl implements JDBCH2Repository {

    private static final Logger log = LogManager.getLogger(JDBCH2RepositoryImpl.class);

    private final JdbcTemplate jdbcTemplateH2;

    public JDBCH2RepositoryImpl(@Qualifier("jdbcTemplateH2") JdbcTemplate jdbcTemplateH2) {
        this.jdbcTemplateH2 = jdbcTemplateH2;
    }

    @PostConstruct
    public void createTable() {
        jdbcTemplateH2.execute("CREATE TABLE users (id SERIAL, name VARCHAR(255))");
    }

    @Override
    public void save(User user) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("INSERT INTO users (name) VALUES (?) ");

        List<Object> params = new ArrayList<>();
        params.add(user.getName());

        try {
            jdbcTemplateH2.update(sbQuery.toString(), params);
        } catch (Exception ex) {
            log.error("@@@ save: ", ex);
        }
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplateH2.query("SELECT * FROM users", (rs, rowNum) -> {
            User user = new User();
            user.setName(rs.getString("name"));
            return user;
        });
    }
}

