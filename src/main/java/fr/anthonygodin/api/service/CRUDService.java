package fr.anthonygodin.api.service;

import fr.anthonygodin.api.dto.DTO;
import fr.anthonygodin.api.dto.EntityDTO;
import fr.anthonygodin.api.exception.RESTException;

import java.util.List;

/**
 * Created by AnthoGdn on 15/03/17.
 */
public interface CRUDService<E extends EntityDTO, C extends DTO> {
    E create(C entityDTO);
    void delete(String id) throws RESTException;
    void deleteAll();
    List<E> findAll();
    E findById(String id) throws RESTException;
    E update(E entityDTO) throws RESTException;
}
