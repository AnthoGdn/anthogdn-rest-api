package fr.anthonygodin.api.controller;

import fr.anthonygodin.api.dto.entity.LanguageDTO;
import fr.anthonygodin.api.dto.entity.LanguageToCreateDTO;
import fr.anthonygodin.api.dto.params.PageParams;
import fr.anthonygodin.api.dto.util.PageableFactory;
import fr.anthonygodin.api.exception.NotFoundException;
import fr.anthonygodin.api.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by AnthoGdn on 15/03/17.
 */
@RestController
@RequestMapping("api/languages")
public class LanguageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LanguageController.class);

    @Autowired
    private CrudService<LanguageDTO, LanguageToCreateDTO> languageService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<LanguageDTO> create(@Validated @RequestBody List<LanguageToCreateDTO> languageToCreateDTOList) {
        LOGGER.info("REST request to create language : {}", languageToCreateDTOList);
        List<LanguageDTO> languages = languageService.create(languageToCreateDTOList);
        return languages;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) throws NotFoundException {
        LOGGER.info("REST request to delete language : {}", id);
        languageService.delete(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<LanguageDTO> findAll(@Valid PageParams pageParams) {
        LOGGER.info("REST request to find all languages");
        Pageable pageable = PageableFactory.getPage(pageParams);
        Page<LanguageDTO> response = languageService.findAll(pageable);
        return response;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LanguageDTO findById(@PathVariable("id") String id) throws NotFoundException {
        LOGGER.info("REST request to find language by id : {}", id);
        LanguageDTO language = languageService.findById(id);
        return language;
    }

    @PutMapping(value = "/{id}")
    public LanguageDTO update(@Validated @RequestBody LanguageDTO language) throws NotFoundException {
        LOGGER.info("REST request to update language : {}", language);
        language = languageService.update(language);
        return language;
    }
}

