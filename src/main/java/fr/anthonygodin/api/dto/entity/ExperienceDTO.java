package fr.anthonygodin.api.dto.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by AnthoGdn on 27/03/17.
 */
@Getter
@Setter
@EqualsAndHashCode
public class ExperienceDTO extends EntityDTO {
    @NotNull
    private Date startDate;
    private Date endDate;
    @NotNull
    private String title;
    private String languages;
    private String job;
    private String description;
    private String location;
}

