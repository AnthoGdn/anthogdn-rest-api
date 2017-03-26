package fr.anthonygodin.api.controller;

import fr.anthonygodin.api.dto.entity.InterestDTO;
import fr.anthonygodin.api.dto.entity.InterestToCreateDTO;
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
@RequestMapping("api/interests")
public class InterestController extends CrudController<InterestDTO, InterestToCreateDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(InterestController.class);

    @Autowired
    private CrudService<InterestDTO, InterestToCreateDTO> interestService;

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }
    @Override
    protected CrudService getService() {
        return interestService;
    }
}

