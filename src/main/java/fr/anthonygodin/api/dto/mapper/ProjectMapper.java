package fr.anthonygodin.api.dto.mapper;

import fr.anthonygodin.api.domain.entity.Project;
import fr.anthonygodin.api.dto.entity.ProjectDTO;
import fr.anthonygodin.api.dto.entity.ProjectToCreateDTO;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Created by agodin on 27/03/17.
 */
public class ProjectMapper {

    private ProjectMapper() {
    }

    public static Project createDTOToModel(ProjectToCreateDTO projectToCreateDTO) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<ProjectToCreateDTO, Project> boundMapper =
                mapperFactory.getMapperFacade(ProjectToCreateDTO.class, Project.class);

        Project project = boundMapper.map(projectToCreateDTO);
        return project;
    }

    public static Project DTOToModel(ProjectDTO projectDTO) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<ProjectDTO, Project> boundMapper =
                mapperFactory.getMapperFacade(ProjectDTO.class, Project.class);

        Project project = boundMapper.map(projectDTO);
        return project;
    }

    public static ProjectDTO modelToDTO(Project project) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<Project, ProjectDTO> boundMapper =
                mapperFactory.getMapperFacade(Project.class, ProjectDTO.class);

        ProjectDTO projectDTO = boundMapper.map(project);
        return projectDTO;
    }
}
