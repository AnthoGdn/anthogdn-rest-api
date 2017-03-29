package fr.anthonygodin.api.dto.mapper;

import fr.anthonygodin.api.domain.entity.Tool;
import fr.anthonygodin.api.dto.entity.ToolDTO;
import fr.anthonygodin.api.dto.entity.ToolToCreateDTO;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Created by agodin on 26/03/17.
 */
public class ToolMapper {

    private ToolMapper() {
    }

    public static Tool createDTOToModel(ToolToCreateDTO toolToCreateDTO) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<ToolToCreateDTO, Tool> boundMapper =
                mapperFactory.getMapperFacade(ToolToCreateDTO.class, Tool.class);

        Tool tool = boundMapper.map(toolToCreateDTO);
        return tool;
    }

    public static Tool DTOToModel(ToolDTO toolDTO) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<ToolDTO, Tool> boundMapper =
                mapperFactory.getMapperFacade(ToolDTO.class, Tool.class);

        Tool tool = boundMapper.map(toolDTO);
        return tool;
    }

    public static ToolDTO modelToDTO(Tool tool) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<Tool, ToolDTO> boundMapper =
                mapperFactory.getMapperFacade(Tool.class, ToolDTO.class);

        ToolDTO toolDTO = boundMapper.map(tool);
        return toolDTO;
    }
}
