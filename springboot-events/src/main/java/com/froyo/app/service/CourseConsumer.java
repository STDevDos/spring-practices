package com.froyo.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class CourseConsumer {

    private static final Logger log = LoggerFactory.getLogger(CourseConsumer.class);

    @EventListener
    public void consume(Course course) {
        log.info("Consume: " + course.getName());
    }

}
