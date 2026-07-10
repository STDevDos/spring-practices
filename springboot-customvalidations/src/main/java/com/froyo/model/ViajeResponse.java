package com.froyo.model;

import com.froyo.messages.AbstractResponse;

public class ViajeResponse extends AbstractResponse {

    private static final long serialVersionUID = 3141555321954313455L;
    private ViajeRequest viajeRequest;

    public ViajeRequest getViajeRequest() {
        return viajeRequest;
    }

    public void setViajeRequest(ViajeRequest viajeRequest) {
        this.viajeRequest = viajeRequest;
    }

    @Override
    public String toString() {
        return "ViajeResponse{" +
                "viajeRequest=" + viajeRequest +
                "} " + super.toString();
    }
}
