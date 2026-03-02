package com.froyo.rememberme.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

    private final JdbcTemplate jdbcTemplate;

    public WebController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @SuppressWarnings("SameReturnValue")
    @RequestMapping(value = "/createTable", method = RequestMethod.GET)
    public String createTable() {
        jdbcTemplate.execute("create table persistent_logins (\r\n" +
                "\tusername varchar(64) not null, \r\n" +
                "\tseries varchar(64) primary key, \t\r\n" +
                "\ttoken varchar(64) not null,\r\n" +
                "\tlast_used timestamp not null\r\n" +
                ")");
        return "home2";
    }

    @SuppressWarnings("SameReturnValue")
    @RequestMapping(value = { "/" })
    public String home() {
        return "home";
    }

    @SuppressWarnings("SameReturnValue")
    @RequestMapping(value = { "/login" })
    public String login() {
        return "login";
    }
}
