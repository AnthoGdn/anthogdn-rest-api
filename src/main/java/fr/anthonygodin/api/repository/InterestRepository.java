package fr.anthonygodin.api.repository;

import fr.anthonygodin.api.domain.entity.Interest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AnthoGdn on 26/03/17.
 */
@Repository
public interface InterestRepository extends
        PagingAndSortingRepository<Interest, String>,
        CrudRepository<Interest, String>
{

}
