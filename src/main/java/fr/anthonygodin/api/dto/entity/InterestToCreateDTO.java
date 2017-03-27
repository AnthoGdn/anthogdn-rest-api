package fr.anthonygodin.api.dto.entity;

import fr.anthonygodin.api.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by AnthoGdn on 26/03/17.
 */
@Data
public class InterestToCreateDTO implements DTO {
    @NotNull
    private String name;
    @NotNull
    private String imgURL;
    private String type;
}
