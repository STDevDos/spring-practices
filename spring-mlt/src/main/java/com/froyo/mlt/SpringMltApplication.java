package com.froyo.mlt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableRetry
public class SpringMltApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMltApplication.class, args);
    }
}

