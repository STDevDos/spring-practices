package com.froyo.mailtrap.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

/**
 * DTO para envío de feedback por email.
 * Usa Java Record (Java 16+): las anotaciones de validación Bean Validation
 * se aplican directamente a los componentes del Record, y son propagadas
 * automáticamente al constructor canónico por el compilador.
 */
public record FeedbackDTO(
        @NotNull String name,
        @NotNull @Email String email,
        @NotNull String feedback
) {
}
