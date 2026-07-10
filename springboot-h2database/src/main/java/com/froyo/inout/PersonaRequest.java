package com.froyo.inout;

/**
 * DTO de entrada para crear/actualizar una Persona.
 * Usa Java Record (Java 16+) que genera automáticamente constructor, getters,
 * equals(), hashCode() y toString().
 */
public record PersonaRequest(String firstName) {
}
