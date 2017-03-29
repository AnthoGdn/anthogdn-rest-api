package fr.anthonygodin.api.dto.mapper;

import fr.anthonygodin.api.domain.entity.Interest;
import fr.anthonygodin.api.dto.entity.InterestDTO;
import fr.anthonygodin.api.dto.entity.InterestToCreateDTO;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Created by agodin on 26/03/17.
 */
public class InterestMapper {

    private InterestMapper() {
    }

    public static Interest createDTOToModel(InterestToCreateDTO interestToCreateDTO) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<InterestToCreateDTO, Interest> boundMapper =
                mapperFactory.getMapperFacade(InterestToCreateDTO.class, Interest.class);

        Interest interest = boundMapper.map(interestToCreateDTO);
        return interest;
    }

    public static Interest DTOToModel(InterestDTO interestDTO) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<InterestDTO, Interest> boundMapper =
                mapperFactory.getMapperFacade(InterestDTO.class, Interest.class);

        Interest interest = boundMapper.map(interestDTO);
        return interest;
    }

    public static InterestDTO modelToDTO(Interest interest) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<Interest, InterestDTO> boundMapper =
                mapperFactory.getMapperFacade(Interest.class, InterestDTO.class);

        InterestDTO interestDTO = boundMapper.map(interest);
        return interestDTO;
    }
}
