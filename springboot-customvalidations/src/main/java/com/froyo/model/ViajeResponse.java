package com.froyo.model;

import com.froyo.messages.AbstractResponse;
import java.util.Objects;

public class ViajeResponse extends AbstractResponse {

    private static final long serialVersionUID = 3141555321954313455L;
    private ViajeRequest viajeRequest = new ViajeRequest();

    public ViajeRequest getViajeRequest() {
        return viajeRequest;
    }

    public void setViajeRequest(ViajeRequest viajeRequest) {
        this.viajeRequest = viajeRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        ViajeResponse that = (ViajeResponse) o;
        return Objects.equals(viajeRequest, that.viajeRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), viajeRequest);
    }

    @Override
    public String toString() {
        return "ViajeResponse{" +
                "viajeRequest=" + viajeRequest +
                "} " + super.toString();
    }
}
