package fr.anthonygodin.api.repository;

import fr.anthonygodin.api.domain.entity.Language;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by AnthoGdn on 19/03/17.
 */
public interface CrudRepository<E, ID extends Serializable> {
}
