package fr.anthonygodin.api.service.impl;

import fr.anthonygodin.api.domain.entity.Language;
import fr.anthonygodin.api.dto.entity.LanguageDTO;
import fr.anthonygodin.api.dto.entity.LanguageToCreateDTO;
import fr.anthonygodin.api.repository.LanguageRepository;
import fr.anthonygodin.api.service.AbstractCrudService;
import fr.anthonygodin.api.dto.mapper.LanguageMapper;
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
    LanguageMapper languageMapper;

    @Override
    protected Language convertCreateDTOToModel(LanguageToCreateDTO languageToCreateDTO) {
        return languageMapper.createDTOToModel(languageToCreateDTO);
    }

    @Override
    protected Language convertDTOToModel(LanguageDTO languageDTO) {
        return languageMapper.DTOToModel(languageDTO);
    }

    @Override
    protected List<LanguageDTO> convertModelListToDTOList(Iterable<Language> languages) {
        List<LanguageDTO> dtos = new LinkedList<>();
        LanguageDTO languageDTO;
        for (Language language : languages) {
            languageDTO = languageMapper.modelToDTO(language);
            dtos.add(languageDTO);
        }
        return dtos;
    }

    @Override
    protected LanguageDTO convertModelToDTO(Language language) {
        return languageMapper.modelToDTO(language);
    }

    @Override
    protected String getEntityName() {
        return "Language";
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
