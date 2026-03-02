package com.fd.springBootRestApi.restful.controller;

import com.fd.springBootRestApi.restful.servcie.FuncionesMatematicas;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * RestController para funciones matemáticas.
 *
 * @author Muguruza
 */
@RestController
public class FuncionesMatematicasWebController {

    @Qualifier(value = "FuncionesMatematicasImpl")
    private final FuncionesMatematicas funcionesMatematicas;

    public FuncionesMatematicasWebController(
            @Qualifier(value = "FuncionesMatematicasImpl") FuncionesMatematicas funcionesMatematicas) {
        this.funcionesMatematicas = funcionesMatematicas;
    }

    /**
     * Enviando parámetro desde el path.
     *
     * @param number
     * @return
     */
    @RequestMapping(value = "/api/isPrimeNumber/{number}", method = RequestMethod.GET)
    @ResponseBody
    public boolean isPrimeNumber(@PathVariable("number") long number) {
        return funcionesMatematicas.isPrimeNumber(number);
    }

}
