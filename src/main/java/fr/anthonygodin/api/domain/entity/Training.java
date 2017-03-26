package fr.anthonygodin.api.domain.entity;

import lombok.Data;
import javax.persistence.Column;
import java.util.Date;

/**
 * Created by AnthoGdn on 26/03/17.
 */
@Data
@javax.persistence.Entity
public class Training extends Entity {
    @Column(nullable = false)
    private Date startDate;
    private Date endDate;
    @Column(nullable = false)
    private String title;
    @Column
    private String description;
    @Column
    private String location;
}
