package com.froyo.app.model.dto;

import com.froyo.messages.AbstractResponse;

/**
 * https://stackoverflow.com/questions/38572566/warning-equals-hashcode-on-data-annotation-lombok-with-inheritance
 */
public class CurrencyEntityDTOResponse extends AbstractResponse {

    private static final long serialVersionUID = 3141555321954313455L;
    private CurrencyEntityDTORequest currencyEntityDTORequest;

    public CurrencyEntityDTORequest getCurrencyEntityDTORequest() {
        return currencyEntityDTORequest;
    }

    public void setCurrencyEntityDTORequest(CurrencyEntityDTORequest currencyEntityDTORequest) {
        this.currencyEntityDTORequest = currencyEntityDTORequest;
    }

    @Override
    public String toString() {
        return "CurrencyEntityDTOResponse{" +
                "currencyEntityDTORequest=" + currencyEntityDTORequest +
                "} " + super.toString();
    }
}
