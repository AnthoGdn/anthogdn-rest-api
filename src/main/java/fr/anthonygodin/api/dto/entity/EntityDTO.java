package fr.anthonygodin.api.dto.entity;

import fr.anthonygodin.api.dto.DTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by AnthoGdn on 15/03/17.
 */
@Getter
@Setter
public abstract class EntityDTO implements DTO {
    private String id;
}
