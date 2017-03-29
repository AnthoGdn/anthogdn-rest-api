package fr.anthonygodin.api.domain.entity;

import fr.anthonygodin.api.domain.Level;
import lombok.Data;
import javax.persistence.Column;

/**
 * Created by AnthoGdn on 26/03/17.
 */
@Data
@javax.persistence.Entity
public class Tool extends Entity {
    @Column(nullable = false)
    private String name;
    @Column
    private Level level;
    @Column(nullable = false)
    private String imgURL;
}
