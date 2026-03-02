package com.froyo.springswagger2.controller;

import com.froyo.springswagger2.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SwaggerRestController {

    private static final Logger log = LoggerFactory.getLogger(SwaggerRestController.class);

    @PostMapping("/testRestController")
    public String testRestController(@RequestBody Persona persona) {

        log.debug("Persona: {} ", persona);
        log.debug("testRestController.....................");

        return "Success";
    }

}
