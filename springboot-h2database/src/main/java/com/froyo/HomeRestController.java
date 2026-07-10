package com.froyo;

import com.froyo.inout.PersonaRequest;
import com.froyo.inout.PersonaResponse;
import com.froyo.model.Persona;
import com.froyo.service.PersonaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeRestController {

    private final PersonaService personaService;

    public HomeRestController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping("/savePersona")
    public PersonaResponse savePersona(@RequestBody PersonaRequest personaRequest) {
        PersonaResponse result = new PersonaResponse();
        result.setPersonaRequest(personaRequest);

        Persona persona = new Persona();
        persona.setName(personaRequest.firstName());

        personaService.save(persona);

        return result;
    }

    @GetMapping("/retrievePersona")
    public List<Persona> retrievePersona() {
        return personaService.findAll();
    }

}
