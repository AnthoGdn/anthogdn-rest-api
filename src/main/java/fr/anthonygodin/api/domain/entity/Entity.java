package fr.anthonygodin.api.domain.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.UUID;

/**
 * Created by AnthoGdn on 15/03/17.
 */
@Getter
@Setter
@javax.persistence.Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class Entity {
    @Column(length = 36)
    @Id
    private String id;
    @Column()
    private int orderNb;

    public Entity() {
        this.id = UUID.randomUUID().toString();
    }
}
