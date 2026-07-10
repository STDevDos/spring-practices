package com.froyo.service.model.dto.files;

/**
 * DTO de entrada para subir un álbum.
 * Usa Java Record (Java 16+): sin boilerplate de getters, equals, hashCode ni toString.
 */
public record UploadAlbumRequest(String name) {
}
