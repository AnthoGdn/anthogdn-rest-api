package fr.anthonygodin.api.domain.entity;

import fr.anthonygodin.api.domain.Level;
import lombok.Data;
import javax.persistence.Column;

/**
 * Created by AnthoGdn on 15/03/17.
 */
@Data
@javax.persistence.Entity
public class Language extends Entity {
    @Column(nullable = false)
    private String name;
    @Column
    private Level level;
    @Column(nullable = false)
    private String imgURL;
}
