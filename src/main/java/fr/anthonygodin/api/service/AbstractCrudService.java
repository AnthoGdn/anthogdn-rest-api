package fr.anthonygodin.api.service;

import fr.anthonygodin.api.domain.entity.Entity;
import fr.anthonygodin.api.dto.DTO;
import fr.anthonygodin.api.dto.entity.EntityDTO;
import fr.anthonygodin.api.exception.Error;
import fr.anthonygodin.api.exception.RESTException;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by AnthoGdn on 19/03/17.
 */
public abstract class AbstractCrudService<E extends Entity, D extends EntityDTO, C extends DTO> implements CrudService<D, C> {

    protected abstract E convertCreateDTOToModel(C toCreateDTO);
    protected abstract E convertDTOToModel(D modelDTO);
    protected abstract List<D> convertModelListToDTOList(Iterable<E> model);
    protected abstract D convertModelToDTO(E model);
    protected abstract String getEntityName();
    protected abstract Error getErrorNotFound();
    protected abstract Logger getLogger();
    protected abstract PagingAndSortingRepository<E, String> getRepository();

    @Override
    public D create(C entityToCreateDTO) {
        D result = null;
        E entity = convertCreateDTOToModel(entityToCreateDTO);
        entity = getRepository().save(entity);
        getLogger().info(getEntityName() + " is created : {}", entity);
        if (entity != null) {
            result = convertModelToDTO(entity);
        }
        return result;
    }

    @Override
    public void deleteAll() {
        getRepository().deleteAll();
        getLogger().info(getEntityName() + " is deleted all");
    }

    public void delete(String id) throws RESTException {
        Entity entity = getRepository().findOne(id);
        if (entity == null) {
            throw new RESTException(getErrorNotFound(), id);
        }
        getRepository().delete(id);
        getLogger().info(getEntityName() +" is deleted : {}", entity);
    }

    public Page<D> findAll(Pageable pageable) {
        Page<E> entitiesPage = getRepository().findAll(pageable);
        getLogger().info(getEntityName() + " is found all");
        List<D> entitiesDTO = convertModelListToDTOList(entitiesPage.getContent());
        Page<D> result = new PageImpl(entitiesDTO, pageable, entitiesPage.getTotalElements());
        getRepository().findAll(pageable);
        return result;
    }

    @Override
    public D findById(String id) throws RESTException {
        D result;
        E entity = getRepository().findOne(id);
        if (entity == null) {
            throw new RESTException(getErrorNotFound(), id);
        }
        getLogger().info(getEntityName() + " is found : {}", entity);
        result = convertModelToDTO(entity);
        return result;
    }

    @Override
    public D update(D entityDTO) throws RESTException {
        String id = entityDTO.getId();
        if (!getRepository().exists(id)) {
            throw new RESTException(getErrorNotFound(), id);
        }
        D result;
        E entity = convertDTOToModel(entityDTO);
        entity = getRepository().save(entity);
        getLogger().info(getEntityName() + " is updated : {}", entity);
        result = convertModelToDTO(entity);
        return result;
    }
}
