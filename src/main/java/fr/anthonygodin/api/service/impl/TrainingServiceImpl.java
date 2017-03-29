package fr.anthonygodin.api.service.impl;

import fr.anthonygodin.api.domain.entity.Training;
import fr.anthonygodin.api.dto.entity.TrainingDTO;
import fr.anthonygodin.api.dto.entity.TrainingToCreateDTO;
import fr.anthonygodin.api.dto.mapper.TrainingMapper;
import fr.anthonygodin.api.repository.TrainingRepository;
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
public class TrainingServiceImpl extends AbstractCrudService<Training, TrainingDTO, TrainingToCreateDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrainingServiceImpl.class);

    @Autowired
    private TrainingRepository trainingRepository;
    TrainingMapper TrainingMapper;

    @Override
    protected Training convertCreateDTOToModel(TrainingToCreateDTO TrainingToCreateDTO) {
        return TrainingMapper.createDTOToModel(TrainingToCreateDTO);
    }

    @Override
    protected Training convertDTOToModel(TrainingDTO TrainingDTO) {
        return TrainingMapper.DTOToModel(TrainingDTO);
    }

    @Override
    protected List<TrainingDTO> convertModelListToDTOList(Iterable<Training> trainings) {
        List<TrainingDTO> dtos = new LinkedList<>();
        TrainingDTO TrainingDTO;
        for (Training training : trainings) {
            TrainingDTO = TrainingMapper.modelToDTO(training);
            dtos.add(TrainingDTO);
        }
        return dtos;
    }

    @Override
    protected TrainingDTO convertModelToDTO(Training training) {
        return TrainingMapper.modelToDTO(training);
    }

    @Override
    protected String getEntityName() {
        return "Training";
    }

    @Override
    protected Logger getLogger() {
            return LOGGER;
    }

    @Override
    protected PagingAndSortingRepository<Training, String> getRepository() {
        return trainingRepository;
    }
}
