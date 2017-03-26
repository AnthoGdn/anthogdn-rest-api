package fr.anthonygodin.api.controller;

import fr.anthonygodin.api.dto.entity.ToolDTO;
import fr.anthonygodin.api.dto.entity.ToolToCreateDTO;
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
@RequestMapping("api/tools")
public class ToolController extends CrudController<ToolDTO, ToolToCreateDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ToolController.class);

    @Autowired
    private CrudService<ToolDTO, ToolToCreateDTO> toolService;

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }
    @Override
    protected CrudService getService() {
        return toolService;
    }
}

