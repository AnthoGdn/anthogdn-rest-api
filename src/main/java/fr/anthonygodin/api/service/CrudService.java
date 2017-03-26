package fr.anthonygodin.api.service;

import fr.anthonygodin.api.dto.DTO;
import fr.anthonygodin.api.dto.entity.EntityDTO;
import fr.anthonygodin.api.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by AnthoGdn on 15/03/17.
 */
public interface CrudService<E extends EntityDTO, C extends DTO> {
    List<E> create(List<C> entityDTO);
    void delete(String id) throws NotFoundException;
    Page<E> findAll(Pageable pageable);
    E findById(String id) throws NotFoundException;
    E update(String id, C entityDTO) throws NotFoundException;
}
