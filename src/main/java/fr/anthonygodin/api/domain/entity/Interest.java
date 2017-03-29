package fr.anthonygodin.api.domain.entity;

import lombok.Data;
import javax.persistence.Column;

/**
 * Created by AnthoGdn on 26/03/17.
 */
@Data
@javax.persistence.Entity
public class Interest extends Entity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String imgURL;
    private String type;
}
