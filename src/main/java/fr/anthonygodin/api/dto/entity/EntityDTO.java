package fr.anthonygodin.api.dto.entity;

import fr.anthonygodin.api.dto.DTO;

/**
 * Created by AnthoGdn on 15/03/17.
 */
public abstract class EntityDTO implements DTO {
    private String id;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
