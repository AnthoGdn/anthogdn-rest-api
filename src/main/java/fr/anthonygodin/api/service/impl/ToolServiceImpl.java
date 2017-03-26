package fr.anthonygodin.api.service.impl;

import fr.anthonygodin.api.domain.entity.Tool;
import fr.anthonygodin.api.dto.entity.ToolDTO;
import fr.anthonygodin.api.dto.entity.ToolToCreateDTO;
import fr.anthonygodin.api.dto.mapper.ToolMapper;
import fr.anthonygodin.api.repository.ToolRepository;
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
public class ToolServiceImpl extends AbstractCrudService<Tool, ToolDTO, ToolToCreateDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ToolServiceImpl.class);

    @Autowired
    private ToolRepository toolRepository;
    ToolMapper ToolMapper;

    @Override
    protected Tool convertCreateDTOToModel(ToolToCreateDTO ToolToCreateDTO) {
        return ToolMapper.createDTOToModel(ToolToCreateDTO);
    }

    @Override
    protected Tool convertDTOToModel(ToolDTO ToolDTO) {
        return ToolMapper.DTOToModel(ToolDTO);
    }

    @Override
    protected List<ToolDTO> convertModelListToDTOList(Iterable<Tool> tools) {
        List<ToolDTO> dtos = new LinkedList<>();
        ToolDTO ToolDTO;
        for (Tool tool : tools) {
            ToolDTO = ToolMapper.modelToDTO(tool);
            dtos.add(ToolDTO);
        }
        return dtos;
    }

    @Override
    protected ToolDTO convertModelToDTO(Tool tool) {
        return ToolMapper.modelToDTO(tool);
    }

    @Override
    protected String getEntityName() {
        return "Tool";
    }

    @Override
    protected Logger getLogger() {
            return LOGGER;
    }

    @Override
    protected PagingAndSortingRepository<Tool, String> getRepository() {
        return toolRepository;
    }
}
