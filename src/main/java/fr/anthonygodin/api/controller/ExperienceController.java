package fr.anthonygodin.api.controller;

import fr.anthonygodin.api.dto.entity.ExperienceDTO;
import fr.anthonygodin.api.dto.entity.ExperienceToCreateDTO;
import fr.anthonygodin.api.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by AnthoGdn on 27/03/17.
 */
@RestController
@RequestMapping("api/experiences")
public class ExperienceController extends CrudController<ExperienceDTO, ExperienceToCreateDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExperienceController.class);

    @Autowired
    private CrudService<ExperienceDTO, ExperienceToCreateDTO> experienceService;

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }
    @Override
    protected CrudService getService() {
        return experienceService;
    }
}

