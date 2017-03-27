package fr.anthonygodin.api.dto.mapper;

import fr.anthonygodin.api.domain.entity.Experience;
import fr.anthonygodin.api.dto.entity.ExperienceDTO;
import fr.anthonygodin.api.dto.entity.ExperienceToCreateDTO;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Created by agodin on 27/03/17.
 */
public class ExperienceMapper {

    private ExperienceMapper() {
    }

    public static Experience createDTOToModel(ExperienceToCreateDTO experienceToCreateDTO) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<ExperienceToCreateDTO, Experience> boundMapper =
                mapperFactory.getMapperFacade(ExperienceToCreateDTO.class, Experience.class);

        Experience experience = boundMapper.map(experienceToCreateDTO);
        return experience;
    }

    public static Experience DTOToModel(ExperienceDTO experienceDTO) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<ExperienceDTO, Experience> boundMapper =
                mapperFactory.getMapperFacade(ExperienceDTO.class, Experience.class);

        Experience experience = boundMapper.map(experienceDTO);
        return experience;
    }

    public static ExperienceDTO modelToDTO(Experience experience) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<Experience, ExperienceDTO> boundMapper =
                mapperFactory.getMapperFacade(Experience.class, ExperienceDTO.class);

        ExperienceDTO experienceDTO = boundMapper.map(experience);
        return experienceDTO;
    }
}
