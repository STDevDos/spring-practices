package com.froyo.service.model.dto.files;

/**
 * DTO de entrada para subida de álbum vía RestTemplate.
 * Usa Java Record (Java 16+): sin boilerplate de getters, equals, hashCode ni toString.
 */
public record RestTemplateUploadAlbumRequest(String name) {
}
