package fr.anthonygodin.api.service.impl;

import fr.anthonygodin.api.domain.entity.Interest;
import fr.anthonygodin.api.dto.entity.InterestDTO;
import fr.anthonygodin.api.dto.entity.InterestToCreateDTO;
import fr.anthonygodin.api.dto.mapper.InterestMapper;
import fr.anthonygodin.api.repository.InterestRepository;
import fr.anthonygodin.api.service.AbstractCrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by AnthoGdn on 26/03/17.
 */
@Service
public class InterestServiceImpl extends AbstractCrudService<Interest, InterestDTO, InterestToCreateDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(InterestServiceImpl.class);

    @Autowired
    private InterestRepository interestRepository;
    InterestMapper InterestMapper;

    @Override
    protected Interest convertCreateDTOToModel(InterestToCreateDTO InterestToCreateDTO) {
        return InterestMapper.createDTOToModel(InterestToCreateDTO);
    }

    @Override
    protected Interest convertDTOToModel(InterestDTO InterestDTO) {
        return InterestMapper.DTOToModel(InterestDTO);
    }

    @Override
    protected List<InterestDTO> convertModelListToDTOList(Iterable<Interest> interests) {
        List<InterestDTO> dtos = new LinkedList<>();
        InterestDTO InterestDTO;
        for (Interest interest : interests) {
            InterestDTO = InterestMapper.modelToDTO(interest);
            dtos.add(InterestDTO);
        }
        return dtos;
    }

    @Override
    protected InterestDTO convertModelToDTO(Interest interest) {
        return InterestMapper.modelToDTO(interest);
    }

    @Override
    protected String getEntityName() {
        return "Interest";
    }

    @Override
    protected Logger getLogger() {
            return LOGGER;
    }

    @Override
    protected PagingAndSortingRepository<Interest, String> getRepository() {
        return interestRepository;
    }
}
