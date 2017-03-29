package fr.anthonygodin.api.repository;

import fr.anthonygodin.api.domain.entity.Tool;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AnthoGdn on 26/03/17.
 */
@Repository
public interface ToolRepository extends
        PagingAndSortingRepository<Tool, String>,
        CrudRepository<Tool, String>
{

}
