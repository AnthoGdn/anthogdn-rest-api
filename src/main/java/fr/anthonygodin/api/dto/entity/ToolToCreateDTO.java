package fr.anthonygodin.api.dto.entity;

import fr.anthonygodin.api.domain.Level;
import fr.anthonygodin.api.dto.DTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by AnthoGdn on 26/03/17.
 */
@Getter
@Setter
@EqualsAndHashCode
public class ToolToCreateDTO implements DTO {
    @NotNull
    private String name;
    @NotNull
    private Level level;
    @NotNull
    private String imgURL;
}
