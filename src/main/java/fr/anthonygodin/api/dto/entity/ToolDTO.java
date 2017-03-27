package fr.anthonygodin.api.dto.entity;

import fr.anthonygodin.api.domain.Level;
import lombok.Data;

/**
 * Created by AnthoGdn on 26/03/17.
 */
@Data
public class ToolDTO extends EntityDTO {
    private String name;
    private Level level;
    private String imgURL;
}

