package com.blubin.freeresources.exception;

public enum EntityType {
    USER("user"),
    CATEGORY("category"),
    REGION("region"),
    PARENT_REGION("parent_region"),
    COUNTRY("country"),
    SCENE_SPOT("scene_spot"),
    COSTUME("costume"),
    WEATHER("weather"),
    REVIEW("review"),

    STREET_VIEW("street_view"),
    ;

    private final String value;

    EntityType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
