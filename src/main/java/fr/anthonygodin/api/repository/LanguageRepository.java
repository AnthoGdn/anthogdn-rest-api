package fr.anthonygodin.api.repository;

import fr.anthonygodin.api.domain.entity.Language;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AnthoGdn on 19/03/17.
 */
@Repository
public interface LanguageRepository extends
        PagingAndSortingRepository<Language, String>,
        CrudRepository<Language, String>
{

}
