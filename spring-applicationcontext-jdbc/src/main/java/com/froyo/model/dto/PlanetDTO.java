package com.froyo.model.dto;

import com.froyo.common.codevalues.PlanetTypeEnum;
import java.util.Objects;

public class PlanetDTO {

    private long id;
    private String name;
    private PlanetTypeEnum planetTypeEnum;

    public PlanetDTO() {
    }

    private PlanetDTO(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.planetTypeEnum = builder.planetTypeEnum;
    }

    public static Builder builder() {
        return new Builder();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlanetTypeEnum getPlanetTypeEnum() {
        return planetTypeEnum;
    }

    public void setPlanetTypeEnum(PlanetTypeEnum planetTypeEnum) {
        this.planetTypeEnum = planetTypeEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PlanetDTO planetDTO = (PlanetDTO) o;
        return id == planetDTO.id && Objects.equals(name, planetDTO.name) && planetTypeEnum == planetDTO.planetTypeEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, planetTypeEnum);
    }

    @Override
    public String toString() {
        return "PlanetDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", planetTypeEnum=" + planetTypeEnum +
                '}';
    }

    public static class Builder {
        private long id;
        private String name;
        private PlanetTypeEnum planetTypeEnum;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder planetTypeEnum(PlanetTypeEnum planetTypeEnum) {
            this.planetTypeEnum = planetTypeEnum;
            return this;
        }

        public PlanetDTO build() {
            return new PlanetDTO(this);
        }
    }
}

