package com.froyo.service.model.dto.files;

import java.util.Objects;

public class RestTemplateUploadAlbumRequest {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestTemplateUploadAlbumRequest that = (RestTemplateUploadAlbumRequest) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "RestTemplateUploadAlbumRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
