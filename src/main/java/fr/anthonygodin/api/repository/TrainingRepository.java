package fr.anthonygodin.api.repository;

import fr.anthonygodin.api.domain.entity.Training;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AnthoGdn on 26/03/17.
 */
@Repository
public interface TrainingRepository extends
        PagingAndSortingRepository<Training, String>,
        CrudRepository<Training, String>
{

}
