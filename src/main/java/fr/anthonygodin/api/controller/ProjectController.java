package fr.anthonygodin.api.controller;

import fr.anthonygodin.api.dto.entity.ProjectDTO;
import fr.anthonygodin.api.dto.entity.ProjectToCreateDTO;
import fr.anthonygodin.api.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * Created by AnthoGdn on 27/03/17.
 */
@RestController
@RequestMapping("api/projects")
public class ProjectController extends CrudController<ProjectDTO, ProjectToCreateDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private CrudService<ProjectDTO, ProjectToCreateDTO> projectService;

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }
    @Override
    protected CrudService getService() {
        return projectService;
    }

    @GetMapping(value = "/test")
    @ResponseStatus(HttpStatus.OK)
    public Date test() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = format.parse("2015-01-01");
        return date;
    }
}

