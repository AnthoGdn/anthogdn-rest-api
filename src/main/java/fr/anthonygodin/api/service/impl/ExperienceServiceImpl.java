package fr.anthonygodin.api.service.impl;

import fr.anthonygodin.api.domain.entity.Experience;
import fr.anthonygodin.api.dto.entity.ExperienceDTO;
import fr.anthonygodin.api.dto.entity.ExperienceToCreateDTO;
import fr.anthonygodin.api.dto.mapper.ExperienceMapper;
import fr.anthonygodin.api.repository.ExperienceRepository;
import fr.anthonygodin.api.service.AbstractCrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by AnthoGdn on 27/03/17.
 */
@Service
public class ExperienceServiceImpl extends AbstractCrudService<Experience, ExperienceDTO, ExperienceToCreateDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExperienceServiceImpl.class);

    @Autowired
    private ExperienceRepository experienceRepository;
    ExperienceMapper ExperienceMapper;

    @Override
    protected Experience convertCreateDTOToModel(ExperienceToCreateDTO ExperienceToCreateDTO) {
        return ExperienceMapper.createDTOToModel(ExperienceToCreateDTO);
    }

    @Override
    protected Experience convertDTOToModel(ExperienceDTO ExperienceDTO) {
        return ExperienceMapper.DTOToModel(ExperienceDTO);
    }

    @Override
    protected List<ExperienceDTO> convertModelListToDTOList(Iterable<Experience> experiences) {
        List<ExperienceDTO> dtos = new LinkedList<>();
        ExperienceDTO ExperienceDTO;
        for (Experience experience : experiences) {
            ExperienceDTO = ExperienceMapper.modelToDTO(experience);
            dtos.add(ExperienceDTO);
        }
        return dtos;
    }

    @Override
    protected ExperienceDTO convertModelToDTO(Experience experience) {
        return ExperienceMapper.modelToDTO(experience);
    }

    @Override
    protected String getEntityName() {
        return "Experience";
    }

    @Override
    protected Logger getLogger() {
            return LOGGER;
    }

    @Override
    protected PagingAndSortingRepository<Experience, String> getRepository() {
        return experienceRepository;
    }
}
