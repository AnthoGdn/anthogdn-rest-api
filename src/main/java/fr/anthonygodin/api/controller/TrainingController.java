package fr.anthonygodin.api.controller;

import fr.anthonygodin.api.dto.entity.TrainingDTO;
import fr.anthonygodin.api.dto.entity.TrainingToCreateDTO;
import fr.anthonygodin.api.dto.params.PageParams;
import fr.anthonygodin.api.dto.util.PageableFactory;
import fr.anthonygodin.api.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


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

    @GetMapping(value = "/test")
    @ResponseStatus(HttpStatus.OK)
    public Date test() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = format.parse("2015-01-01");
        return date;
    }
}

