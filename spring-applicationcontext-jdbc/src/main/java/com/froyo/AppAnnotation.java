package com.froyo;

import com.froyo.config.AppConfig;
import com.froyo.service.AnimalsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AppAnnotation {

    private static final Logger log = Logger.getLogger(AppAnnotation.class.getName());

    public static void main(String[] args) {

        log.info("Iniciando AppAnnotation");

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AnimalsService animalsService = context.getBean(AnimalsService.class);

        animalsService.findAll().forEach(animal -> System.out.println(animal.getName()));

    }

}

