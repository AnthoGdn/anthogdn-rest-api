package fr.anthonygodin.api.service.impl;

import fr.anthonygodin.api.domain.entity.Language;
import fr.anthonygodin.api.dto.entity.LanguageDTO;
import fr.anthonygodin.api.dto.entity.LanguageToCreateDTO;
import fr.anthonygodin.api.exception.Error;
import fr.anthonygodin.api.repository.LanguageRepository;
import fr.anthonygodin.api.service.AbstractCrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by AnthoGdn on 15/03/17.
 */
@Service
public class LanguageServiceImpl extends AbstractCrudService<Language, LanguageDTO, LanguageToCreateDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LanguageServiceImpl.class);

    @Autowired
    private LanguageRepository languageRepository;


    @Override
    protected Language convertCreateDTOToModel(LanguageToCreateDTO languageToCreateDTO) {
        Language language = new Language();

        language.setName(languageToCreateDTO.getName());
        language.setLevel(languageToCreateDTO.getLevel());
        language.setImgURL(languageToCreateDTO.getImgURL());

        return language;
    }

    @Override
    protected Language convertDTOToModel(LanguageDTO languageDTO) {
        Language language = new Language();

        language.setId(languageDTO.getId());
        language.setName(languageDTO.getName());
        language.setLevel(languageDTO.getLevel());
        language.setImgURL(languageDTO.getImgURL());

        return language;
    }

    @Override
    protected List<LanguageDTO> convertModelListToDTOList(Iterable<Language> languages) {
        List<LanguageDTO> dtos = new LinkedList<>();
        LanguageDTO languageDTO;
        for (Language language : languages) {
            languageDTO = new LanguageDTO(language);
            dtos.add(languageDTO);
        }
        return dtos;
    }

    @Override
    protected LanguageDTO convertModelToDTO(Language language) {
        return new LanguageDTO(language);
    }

    @Override
    protected String getEntityName() {
        return "Language";
    }

    @Override
    protected Error getErrorNotFound() {
        return Error.LANGUAGE_NOT_FOUND;
    }

    @Override
    protected Logger getLogger() {
            return LOGGER;
    }

    @Override
    protected PagingAndSortingRepository<Language, String> getRepository() {
        return languageRepository;
    }
}
