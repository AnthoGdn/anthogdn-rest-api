package fr.anthonygodin.api.dto.entity;

import fr.anthonygodin.api.domain.entity.Language;
import fr.anthonygodin.api.dto.DTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by AnthoGdn on 15/03/17.
 */
@Getter
@Setter
@EqualsAndHashCode
public class LanguageToCreateDTO implements DTO {
    @NotNull
    private String name;
    @NotNull
    private Language.Level level;
    @NotNull
    private String imgURL;
}
