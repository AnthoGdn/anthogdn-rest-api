package fr.anthonygodin.api.dto.entity;

import fr.anthonygodin.api.domain.entity.Language;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by AnthoGdn on 15/03/17.
 */
@Getter
@Setter
@EqualsAndHashCode
public class LanguageDTO extends EntityDTO {
    private String name;
    private Language.Level level;
    private String imgURL;
}

