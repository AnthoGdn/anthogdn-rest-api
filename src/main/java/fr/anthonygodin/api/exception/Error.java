package fr.anthonygodin.api.exception;

/**
 * Created by AnthoGdn on 17/03/17.
 */
public enum Error {
    LANGUAGE_NOT_FOUND("language.not_found", "language is not found", EntityName.LANGUAGE);

    private final String key;
    private final String message;
    private final EntityName entityName;

    Error(String key, String message, EntityName entityName) {
        this.key = key;
        this.message = message;
        this.entityName = entityName;
    }

    public String getKey() {
        return key;
    }
    public String getMessage() {
        return message;
    }
    public EntityName getEntityName() {
        return entityName;
    }
}
