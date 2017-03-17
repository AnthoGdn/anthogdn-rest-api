package fr.anthonygodin.api.repository;

import fr.anthonygodin.api.domain.entity.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by AnthoGdn on 15/03/17.
 */
@Repository
public interface LanguageRepository extends CrudRepository<Language, String> {
}
