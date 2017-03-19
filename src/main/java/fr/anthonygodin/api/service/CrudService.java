package fr.anthonygodin.api.service;

import fr.anthonygodin.api.domain.entity.Language;
import fr.anthonygodin.api.dto.DTO;
import fr.anthonygodin.api.dto.entity.EntityDTO;
import fr.anthonygodin.api.dto.params.PageParams;
import fr.anthonygodin.api.exception.RESTException;
import fr.anthonygodin.api.dto.params.OrderBy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by AnthoGdn on 15/03/17.
 */
public interface CrudService<E extends EntityDTO, C extends DTO> {
    E create(C entityDTO); // Replace by list of entity
    void delete(String id) throws RESTException;
    void deleteAll();
    Page<E> findAll(Pageable pageable);
    E findById(String id) throws RESTException;
    E update(E entityDTO) throws RESTException;
}
