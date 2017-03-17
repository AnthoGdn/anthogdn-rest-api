package fr.anthonygodin.api.domain.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * Created by AnthoGdn on 15/03/17.
 */
@javax.persistence.Entity
public abstract class Entity {

    @Column(length = 36)
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

}
