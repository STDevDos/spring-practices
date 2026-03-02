package com.froyo.simpleRestClient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.client.RestTemplate;

/**
 * @author Froy
 *         <p>
 *         CommandLineRunner: aplicación de arranque con el método run el cual
 *         se le puede enviar un arreglo de String.
 *         Aplicación ejecutada en la consola.
 */
@SpringBootApplication
public class AppSpringBootRestClient implements CommandLineRunner {

    private static final Logger log = LogManager.getLogger(AppSpringBootRestClient.class);

    public static void main(String[] args) {

        // old option
        // SpringApplication app = new SpringApplication(AppSpringBootRestClient.class);
        // app.setWebApplicationType(WebApplicationType.NONE);
        // args[0] = "Froy";
        // app.run(args);

        // new option 20/09/2020
        args[0] = "Froy";
        new SpringApplicationBuilder(AppSpringBootRestClient.class)
                .web(WebApplicationType.NONE)
                .run(args);

    }

    @Override
    public void run(String... argsRun) {

        /*
         * Una forma de obtener el response de otro proyecto es utilizando RestTemplate.
         * El ejemplo se esta corriendo una aplicación en el puerto 8080 y ese proyecto
         * tiene un Request @GetMapping("retrieveCustomer")
         * :: Método getForObject::
         * 
         * Parámetro 1 : el url del request.
         * Parámetro 2 : el tipo de objeto que regresará.
         * 
         */

        RestTemplate plantilla = new RestTemplate();
        String resultado = plantilla.getForObject("http://localhost:8080/retrieveCustomer", String.class);

        log.info("Parámetro: " + argsRun[0]);
        log.info(resultado);
    }
}
