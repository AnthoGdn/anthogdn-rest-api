package fr.anthonygodin.api.controller;

import fr.anthonygodin.api.dto.entity.LanguageDTO;
import fr.anthonygodin.api.dto.entity.LanguageToCreateDTO;
import fr.anthonygodin.api.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by AnthoGdn on 15/03/17.
 */
@RestController
@RequestMapping("api/languages")
public class LanguageController extends CrudController<LanguageDTO, LanguageToCreateDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LanguageController.class);

    @Autowired
    private CrudService<LanguageDTO, LanguageToCreateDTO> languageService;

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }
    @Override
    protected CrudService getService() {
        return languageService;
    }
}

