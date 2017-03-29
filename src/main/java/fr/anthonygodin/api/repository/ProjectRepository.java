package fr.anthonygodin.api.repository;

import fr.anthonygodin.api.domain.entity.Project;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AnthoGdn on 27/03/17.
 */
@Repository
public interface ProjectRepository extends
        PagingAndSortingRepository<Project, String>,
        CrudRepository<Project, String>
{

}
