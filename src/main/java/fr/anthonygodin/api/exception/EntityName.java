package fr.anthonygodin.api.exception;

/**
 * Created by AnthoGdn on 17/03/17.
 */
public enum EntityName {
    LANGUAGE("Language");

    private String name;

    EntityName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
