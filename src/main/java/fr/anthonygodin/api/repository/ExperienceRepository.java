package fr.anthonygodin.api.repository;

import fr.anthonygodin.api.domain.entity.Experience;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AnthoGdn on 27/03/17.
 */
@Repository
public interface ExperienceRepository extends
        PagingAndSortingRepository<Experience, String>,
        CrudRepository<Experience, String>
{

}
