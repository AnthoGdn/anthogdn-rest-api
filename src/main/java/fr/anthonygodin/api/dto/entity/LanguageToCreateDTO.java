package fr.anthonygodin.api.dto.entity;

import fr.anthonygodin.api.domain.Level;
import fr.anthonygodin.api.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by AnthoGdn on 15/03/17.
 */
@Data
public class LanguageToCreateDTO implements DTO {
    @NotNull
    private String name;
    @NotNull
    private Level level;
    @NotNull
    private String imgURL;
}
