package com.froyo.model;

import com.froyo.customvalidation.ViajeValidator;
import java.io.Serializable;
import java.util.Objects;

@ViajeValidator
public class ViajeRequest implements Serializable {

    private String name;
    private String origin;
    private String destination;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ViajeRequest that = (ViajeRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(origin, that.origin)
                && Objects.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, origin, destination);
    }

    @Override
    public String toString() {
        return "ViajeRequest{" +
                "name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
