package com.froyo.service;

import com.froyo.model.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {
    private final List<Persona> personas = new ArrayList<>();

    public void save(Persona persona) {
        personas.add(persona);
    }

    public List<Persona> findAll() {
        return personas;
    }
}
