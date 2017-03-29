package fr.anthonygodin.api.dto.entity;

import lombok.Data;

/**
 * Created by AnthoGdn on 26/03/17.
 */
@Data
public class InterestDTO extends EntityDTO {
    private String name;
    private String imgURL;
    private String type;
}

