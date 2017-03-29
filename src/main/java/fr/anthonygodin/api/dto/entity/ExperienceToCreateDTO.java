package fr.anthonygodin.api.dto.entity;

import fr.anthonygodin.api.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by AnthoGdn on 27/03/17.
 */
@Data
public class ExperienceToCreateDTO implements DTO {
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
