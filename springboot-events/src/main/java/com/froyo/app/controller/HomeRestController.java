package com.froyo.app.controller;

import com.froyo.app.service.CoursePublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {

    private final CoursePublisher coursePublisher;

    public HomeRestController(CoursePublisher coursePublisher) {
        this.coursePublisher = coursePublisher;
    }

    @GetMapping("/publish/{name}")
    public String publish(@PathVariable("name") String name) {
        coursePublisher.publish(name);
        return "success";
    }

}
