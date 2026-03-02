package com.froyo.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class CoursePublisher {

    private static final Logger log = LoggerFactory.getLogger(CoursePublisher.class);

    private final ApplicationEventPublisher applicationEventPublisher;

    public CoursePublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(String name) {
        log.info("Publish: " + name);
        applicationEventPublisher.publishEvent(new Course(name));
    }

}
