package com.froyo.inout;

import com.froyo.messages.AbstractResponse;
import java.util.Objects;

public class PersonaResponse extends AbstractResponse {

    private static final long serialVersionUID = 3141555321954313455L;
    private PersonaRequest personaRequest = new PersonaRequest();

    public PersonaRequest getPersonaRequest() {
        return personaRequest;
    }

    public void setPersonaRequest(PersonaRequest personaRequest) {
        this.personaRequest = personaRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        PersonaResponse that = (PersonaResponse) o;
        return Objects.equals(personaRequest, that.personaRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), personaRequest);
    }

    @Override
    public String toString() {
        return "PersonaResponse{" +
                "personaRequest=" + personaRequest +
                "} " + super.toString();
    }
}
