package fr.anthonygodin.api.dto.mapper;

import fr.anthonygodin.api.domain.entity.Training;
import fr.anthonygodin.api.dto.entity.TrainingDTO;
import fr.anthonygodin.api.dto.entity.TrainingToCreateDTO;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Created by agodin on 26/03/17.
 */
public class TrainingMapper {

    private TrainingMapper() {
    }

    public static Training createDTOToModel(TrainingToCreateDTO trainingToCreateDTO) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<TrainingToCreateDTO, Training> boundMapper =
                mapperFactory.getMapperFacade(TrainingToCreateDTO.class, Training.class);

        Training training = boundMapper.map(trainingToCreateDTO);
        return training;
    }

    public static Training DTOToModel(TrainingDTO trainingDTO) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<TrainingDTO, Training> boundMapper =
                mapperFactory.getMapperFacade(TrainingDTO.class, Training.class);

        Training training = boundMapper.map(trainingDTO);
        return training;
    }

    public static TrainingDTO modelToDTO(Training training) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<Training, TrainingDTO> boundMapper =
                mapperFactory.getMapperFacade(Training.class, TrainingDTO.class);

        TrainingDTO trainingDTO = boundMapper.map(training);
        return trainingDTO;
    }
}
