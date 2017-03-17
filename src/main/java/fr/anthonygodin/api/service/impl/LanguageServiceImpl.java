package fr.anthonygodin.api.service.impl;

import fr.anthonygodin.api.exception.EntityName;
import fr.anthonygodin.api.exception.Error;
import fr.anthonygodin.api.exception.RESTException;
import fr.anthonygodin.api.repository.LanguageRepository;
import fr.anthonygodin.api.domain.entity.Language;
import fr.anthonygodin.api.dto.Entity.LanguageDTO;
import fr.anthonygodin.api.dto.Entity.LanguageToCreateDTO;
import fr.anthonygodin.api.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by AnthoGdn on 15/03/17.
 */
@Service
public class LanguageServiceImpl implements LanguageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LanguageServiceImpl.class);

    @Autowired
    private LanguageRepository languageRepository;

    public LanguageServiceImpl(){}
    protected LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public LanguageDTO create(LanguageToCreateDTO languageToCreateDTO) {
        LanguageDTO result = null;
        Language language = createDTOToModel(languageToCreateDTO);
        language = languageRepository.save(language);
        LOGGER.info("Language is created : {}", language);
        if (language != null) {
            result = new LanguageDTO(language);
        }
        return result;
    }

    @Override
    public void delete(String id) throws RESTException {
        Language language = languageRepository.findOne(id);
        if (language == null) {
            throw new RESTException(Error.LANGUAGE_NOT_FOUND, id);
        }
        languageRepository.delete(id);
        LOGGER.info("Language is deleted : {}", language);
    }

    @Override
    public void deleteAll() {
        languageRepository.deleteAll();
        LOGGER.info("Languages is deleted all");
    }

    @Override
    public List<LanguageDTO> findAll() {
        List<LanguageDTO> result;
        Iterable<Language> languages = languageRepository.findAll();
        LOGGER.info("Languages is found all");
        result = modelsToDTOs(languages);
        return result;
    }

    @Override
    public LanguageDTO findById(String id) throws RESTException {
        LanguageDTO result;
        Language language = languageRepository.findOne(id);
        if (language == null) {
            throw new RESTException(Error.LANGUAGE_NOT_FOUND, id);
        }
        LOGGER.info("Language is found : {}", language);
        result = new LanguageDTO(language);
        return result;
    }

    @Override
    public LanguageDTO update(LanguageDTO languageDTO) throws RESTException {
        String id = languageDTO.getId();
        if (!languageRepository.exists(id)) {
            throw new RESTException(Error.LANGUAGE_NOT_FOUND, id);
        }
        LanguageDTO result;
        Language language = dtoToModel(languageDTO);
        language = languageRepository.save(language);
        LOGGER.info("Language is updated : {}", language);
        result = new LanguageDTO(language);
        return result;
    }

    // PRIVATE
    private Language createDTOToModel(LanguageToCreateDTO languageToCreateDTO) {
        Language language = new Language();

        language.setName(languageToCreateDTO.getName());
        language.setLevel(languageToCreateDTO.getLevel());
        language.setImgURL(languageToCreateDTO.getImgURL());

        return language;
    }
    private Language dtoToModel(LanguageDTO languageDTO) {
        Language language = new Language();

        language.setId(languageDTO.getId());
        language.setName(languageDTO.getName());
        language.setLevel(languageDTO.getLevel());
        language.setImgURL(languageDTO.getImgURL());

        return language;
    }

    private List<LanguageDTO> modelsToDTOs(Iterable<Language> languages) {
        List<LanguageDTO> dtos = new LinkedList<>();
        LanguageDTO languageDTO;
        for (Language language : languages) {
            languageDTO = new LanguageDTO(language);
            dtos.add(languageDTO);
        }
        return dtos;
    }
}
