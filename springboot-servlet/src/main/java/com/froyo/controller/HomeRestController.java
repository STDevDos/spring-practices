package com.froyo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

/**
 * @author Froy
 */
@RestController
public class HomeRestController {

    @RequestMapping("/app/home")
    public String helloMsg(HttpServletRequest request) {
        request.getSession();
        String user = "user: " + request.getServletContext().getAttribute("user");
        String name = "name: " + request.getServletContext().getAttribute("name");
        String dato = "dato: " + request.getServletContext().getAttribute("dato");
        return user + "</br> " + name + "</br> " + dato;
    }

}

