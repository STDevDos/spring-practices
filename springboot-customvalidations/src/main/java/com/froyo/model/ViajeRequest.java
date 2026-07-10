package com.froyo.model;

import com.froyo.customvalidation.ViajeValidator;
import java.io.Serializable;

/**
 * DTO de entrada para solicitudes de viaje.
 * Usa Java Record (Java 16+) con validación personalizada @ViajeValidator.
 * Los Records implementan Serializable sin necesidad de serialVersionUID
 * (solo necesario si se requiere serialización binaria explícita con versión fija).
 */
@ViajeValidator
public record ViajeRequest(String name, String origin, String destination) implements Serializable {
}
