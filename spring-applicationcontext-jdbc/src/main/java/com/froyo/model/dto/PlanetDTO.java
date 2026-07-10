package com.froyo.model.dto;

import com.froyo.common.codevalues.PlanetTypeEnum;

/**
 * DTO de transferencia de datos para Planetas.
 * Usa Java Record (Java 16+): elimina el Builder manual, getters, setters,
 * equals(), hashCode() y toString() — todo generado automáticamente por el compilador.
 *
 * <p>Uso:
 * <pre>{@code
 *   var planeta = new PlanetDTO(1L, "Tierra", PlanetTypeEnum.TERRESTRIAL);
 * }</pre>
 */
public record PlanetDTO(long id, String name, PlanetTypeEnum planetTypeEnum) {
}
