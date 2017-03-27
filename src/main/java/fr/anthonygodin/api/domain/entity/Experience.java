package fr.anthonygodin.api.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by AnthoGdn on 27/03/17.
 */
@Data
@javax.persistence.Entity
public class Experience extends Entity {
    @Column(nullable = false)
    private Date startDate;
    private Date endDate;
    @Column(nullable = false)
    private String title;
    @Column
    private String languages;
    @Column
    private String job;
    @Column
    private String description;
    @Column
    private String location;
}
