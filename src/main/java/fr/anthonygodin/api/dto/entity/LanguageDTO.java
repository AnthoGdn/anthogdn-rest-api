package fr.anthonygodin.api.dto.entity;

import fr.anthonygodin.api.domain.Level;
import lombok.Data;

/**
 * Created by AnthoGdn on 15/03/17.
 */
@Data
public class LanguageDTO extends EntityDTO {
    private String name;
    private Level level;
    private String imgURL;
}

