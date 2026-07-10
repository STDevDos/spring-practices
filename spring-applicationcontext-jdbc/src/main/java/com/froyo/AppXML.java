package com.froyo;

import com.froyo.service.AnimalsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

public class AppXML {

    private static final Logger log = Logger.getLogger(AppXML.class.getName());

    public static void main(String[] args) {

        log.info("Iniciando AppXML");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnimalsService animalsService = context.getBean("animalsServiceImpl", AnimalsService.class);

        animalsService.findAll().forEach(animal -> System.out.println(animal.getName()));

    }

}

