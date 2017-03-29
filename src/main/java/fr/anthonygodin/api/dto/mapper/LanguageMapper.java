package fr.anthonygodin.api.dto.mapper;

import fr.anthonygodin.api.domain.entity.Language;
import fr.anthonygodin.api.dto.entity.LanguageDTO;
import fr.anthonygodin.api.dto.entity.LanguageToCreateDTO;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Created by agodin on 26/03/17.
 */
public class LanguageMapper {

    private LanguageMapper() {
    }

    public static Language createDTOToModel(LanguageToCreateDTO languageToCreateDTO) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<LanguageToCreateDTO, Language> boundMapper =
                mapperFactory.getMapperFacade(LanguageToCreateDTO.class, Language.class);

        Language language = boundMapper.map(languageToCreateDTO);
        return language;
    }

    public static Language DTOToModel(LanguageDTO languageDTO) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<LanguageDTO, Language> boundMapper =
                mapperFactory.getMapperFacade(LanguageDTO.class, Language.class);

        Language language = boundMapper.map(languageDTO);
        return language;
    }

    public static LanguageDTO modelToDTO(Language language) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<Language, LanguageDTO> boundMapper =
                mapperFactory.getMapperFacade(Language.class, LanguageDTO.class);

        LanguageDTO languageDTO = boundMapper.map(language);
        return languageDTO;
    }
}
