package fr.anthonygodin.api.controller;

import fr.anthonygodin.api.dto.DTO;
import fr.anthonygodin.api.dto.entity.EntityDTO;
import fr.anthonygodin.api.dto.params.PageParams;
import fr.anthonygodin.api.dto.util.PageableFactory;
import fr.anthonygodin.api.exception.NotFoundException;
import fr.anthonygodin.api.service.CrudService;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by agodin on 26/03/17.
 */
public abstract class CrudController<EDTO extends EntityDTO, ToCreateDTO extends DTO> {

    protected abstract Logger getLogger();
    protected abstract CrudService<EDTO, ToCreateDTO> getService();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<EDTO> create(@Validated @RequestBody List<ToCreateDTO> entityToCreateDTOList) {
        getLogger().info("REST request to create entity : {}", entityToCreateDTOList);
        List<EDTO> entities = getService().create(entityToCreateDTOList);
        return entities;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) throws NotFoundException {
        getLogger().info("REST request to delete entity : {}", id);
        getService().delete(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<EDTO> findAll(@Valid PageParams pageParams) {
        getLogger().info("REST request to find all entities");
        Pageable pageable = PageableFactory.getPage(pageParams);
        Page<EDTO> response = getService().findAll(pageable);
        return response;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EDTO findById(@PathVariable("id") String id) throws NotFoundException {
        getLogger().info("REST request to find entity by id : {}", id);
        EDTO entity = getService().findById(id);
        return entity;
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EDTO update(
            @PathVariable("id") String id,
            @Validated @RequestBody ToCreateDTO entityToCreateDTO
    ) throws NotFoundException {
        getLogger().info("REST request to update entity : {}", entityToCreateDTO);
        EDTO entityDTO = getService().update(id, entityToCreateDTO);
        return entityDTO;
    }
}
