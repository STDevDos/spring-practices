package com.froyo.inout;

import com.froyo.messages.AbstractResponse;

public class PersonaResponse extends AbstractResponse {

    private static final long serialVersionUID = 3141555321954313455L;
    private PersonaRequest personaRequest;

    public PersonaRequest getPersonaRequest() {
        return personaRequest;
    }

    public void setPersonaRequest(PersonaRequest personaRequest) {
        this.personaRequest = personaRequest;
    }

    @Override
    public String toString() {
        return "PersonaResponse{" +
                "personaRequest=" + personaRequest +
                "} " + super.toString();
    }
}
