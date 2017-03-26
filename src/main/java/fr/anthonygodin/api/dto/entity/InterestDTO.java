package fr.anthonygodin.api.dto.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by AnthoGdn on 26/03/17.
 */
@Getter
@Setter
@EqualsAndHashCode
public class InterestDTO extends EntityDTO {
    private String name;
    private String imgURL;
    private String type;
}

