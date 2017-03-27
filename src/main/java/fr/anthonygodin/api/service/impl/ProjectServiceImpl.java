package fr.anthonygodin.api.service.impl;

import fr.anthonygodin.api.domain.entity.Project;
import fr.anthonygodin.api.dto.entity.ProjectDTO;
import fr.anthonygodin.api.dto.entity.ProjectToCreateDTO;
import fr.anthonygodin.api.dto.mapper.ProjectMapper;
import fr.anthonygodin.api.repository.ProjectRepository;
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
public class ProjectServiceImpl extends AbstractCrudService<Project, ProjectDTO, ProjectToCreateDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Autowired
    private ProjectRepository projectRepository;
    ProjectMapper ProjectMapper;

    @Override
    protected Project convertCreateDTOToModel(ProjectToCreateDTO ProjectToCreateDTO) {
        return ProjectMapper.createDTOToModel(ProjectToCreateDTO);
    }

    @Override
    protected Project convertDTOToModel(ProjectDTO ProjectDTO) {
        return ProjectMapper.DTOToModel(ProjectDTO);
    }

    @Override
    protected List<ProjectDTO> convertModelListToDTOList(Iterable<Project> projects) {
        List<ProjectDTO> dtos = new LinkedList<>();
        ProjectDTO ProjectDTO;
        for (Project project : projects) {
            ProjectDTO = ProjectMapper.modelToDTO(project);
            dtos.add(ProjectDTO);
        }
        return dtos;
    }

    @Override
    protected ProjectDTO convertModelToDTO(Project project) {
        return ProjectMapper.modelToDTO(project);
    }

    @Override
    protected String getEntityName() {
        return "Project";
    }

    @Override
    protected Logger getLogger() {
            return LOGGER;
    }

    @Override
    protected PagingAndSortingRepository<Project, String> getRepository() {
        return projectRepository;
    }
}
