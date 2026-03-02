package com.froyo.common.codevalues;

public enum PlanetTypeEnum {
    ROCKY("Rocky"),
    GAS_GIANT("Gas Giant"),
    ICE_GIANT("Ice Giant"),
    EARTH("Earth"),
    MARS("Mars");

    private final String description;

    PlanetTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "PlanetTypeEnum{" +
                "description='" + description + '\'' +
                "} " + super.toString();
    }
}

