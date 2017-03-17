package fr.anthonygodin.api.controller;

import fr.anthonygodin.api.dto.Entity.LanguageDTO;
import fr.anthonygodin.api.dto.Entity.LanguageToCreateDTO;
import fr.anthonygodin.api.dto.Response.DataListResponseDTO;
import fr.anthonygodin.api.dto.Response.DataResponseDTO;
import fr.anthonygodin.api.dto.Response.ErrorResponseDTO;
import fr.anthonygodin.api.dto.Response.ResponseDTO;
import fr.anthonygodin.api.exception.RESTException;
import fr.anthonygodin.api.service.LanguageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by AnthoGdn on 15/03/17.
 */
@RestController
@RequestMapping("api/languages")
public class LanguageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LanguageController.class);

    @Autowired
    private LanguageService languageService;

    @PostMapping
    public ResponseEntity<ResponseDTO> create(@RequestBody LanguageToCreateDTO languageToCreateDTO) {
        LOGGER.info("REST request to create language : {}", languageToCreateDTO);
        LanguageDTO language = languageService.create(languageToCreateDTO);
        if (language != null) {
            DataResponseDTO response = new DataResponseDTO<LanguageDTO>();
            response.setData(language);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            ErrorResponseDTO response = new ErrorResponseDTO();
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) throws RESTException {
        LOGGER.info("REST request to delete language : {}", id);
        languageService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> findAll() {
        LOGGER.info("REST request to find all languages");
        List<LanguageDTO> languages = languageService.findAll();
        DataListResponseDTO<LanguageDTO> response = new DataListResponseDTO<>();
        response.setData(languages);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LanguageDTO> findById(@PathVariable("id") String id) throws RESTException {
        LOGGER.info("REST request to find language by id : {}", id);
        LanguageDTO language = languageService.findById(id);
        if (language == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(language, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ResponseDTO> update(@RequestBody LanguageDTO language) throws RESTException {
        LOGGER.info("REST request to update language : {}", language);
        language = languageService.update(language);
        if (language == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        DataResponseDTO<LanguageDTO> response = new DataResponseDTO<>();
        response.setData(language);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

