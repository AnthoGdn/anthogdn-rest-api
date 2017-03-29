package fr.anthonygodin.api.controller;

import fr.anthonygodin.api.dto.entity.TrainingDTO;
import fr.anthonygodin.api.dto.entity.TrainingToCreateDTO;
import fr.anthonygodin.api.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by AnthoGdn on 26/03/17.
 */
@RestController
@RequestMapping("api/trainings")
public class TrainingController extends CrudController<TrainingDTO, TrainingToCreateDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrainingController.class);

    @Autowired
    private CrudService<TrainingDTO, TrainingToCreateDTO> trainingService;

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }
    @Override
    protected CrudService getService() {
        return trainingService;
    }
}

