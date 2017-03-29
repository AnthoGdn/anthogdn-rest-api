package fr.anthonygodin.api.cucumber.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import fr.anthonygodin.api.Application;
import fr.anthonygodin.api.domain.Level;
import fr.anthonygodin.api.domain.entity.Language;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by AnthoGdn on 18/03/17.
 */
@ContextConfiguration(classes = Application.class,
        initializers = ConfigFileApplicationContextInitializer.class)
public class LanguagesSteps extends AbstractSteps {

    @Given("^there are these languages data in database:$")
    public void thereAreTheseLanguagesDataInDatabase(DataTable languages) throws Throwable {
        List<Map<String, String>> maps = languages.asMaps(String.class, String.class);
        maps.forEach(map -> {
            String id = map.get("id");
            String name = map.get("name");
            String url = map.get("url");
            Level level = Level.valueOf(map.get("level"));
            String orderNbString = map.get("orderNb");
            int orderNb = 0;
            if (orderNbString != null) {
                orderNb = Integer.valueOf(orderNbString);
            }

            persistLanguage(id, name, level, url, orderNb);
        });
    }

    @Given("^the languages data database is:$")
    public void theLanguagesDatabaseIs(DataTable languages) throws Throwable {
        List<Map<String, String>> maps = languages.asMaps(String.class, String.class);

        boolean isCorrectLanguageTableSize = languageTableSizeIs(maps.size());
        assertTrue(isCorrectLanguageTableSize);
        languageTableIsCorrect(maps);
    }

    // PRIVATE
    private void persistLanguage(String id, String name, Level level, String url, int orderNb) {
        Language language = new Language();

        language.setId(id);
        language.setName(name);
        language.setImgURL(url);
        language.setLevel(level);
        language.setOrderNb(orderNb);

        entityManager.persist(language);
    }

    private boolean languageTableSizeIs(long size) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(Language.class)));
        long sizeLanguageTable = entityManager.createQuery(cq).getSingleResult();
        return sizeLanguageTable == size;
    }

    private void languageTableIsCorrect(List<Map<String, String>> maps) {
        maps.forEach(map -> {
            String id = map.get("id");
            String name = map.get("name");
            String url = map.get("url");
            Level level = Level.valueOf(map.get("level"));

            String orderNbString = map.get("orderNb");
            int orderNb = 0;
            if (orderNbString != null) {
                orderNb = Integer.valueOf(orderNbString);
            }
            if (id == null)
                languageIsInDatabase(name, level, url, orderNb);
            else
                languageIsInDatabase(id, name, level, url, orderNb);
        });
    }

    private void languageIsInDatabase(String name, Level level, String url, int orderNb) {
        Language language = entityManager.createQuery(
                "SELECT l FROM Language l WHERE " +
                        "l.name = :nameL AND l.level = :levelL AND l.imgURL = :urlL AND l.orderNb = :orderNbL"
                , Language.class)
                .setParameter("nameL", name)
                .setParameter("levelL", level)
                .setParameter("urlL", url)
                .setParameter("orderNbL", orderNb)
                .getSingleResult();
        assertThat(language).isNotNull();
    }

    private void languageIsInDatabase(String id, String name, Level level, String url, int orderNb) {
        Language language = entityManager.createQuery(
                "SELECT l FROM Language l WHERE " +
                        "l.id = :idL AND l.name = :nameL AND l.level = :levelL AND l.imgURL = :urlL AND l.orderNb = :orderNbL"
                , Language.class)
                .setParameter("idL", id)
                .setParameter("nameL", name)
                .setParameter("levelL", level)
                .setParameter("urlL", url)
                .setParameter("orderNbL", orderNb)
                .getSingleResult();
        assertThat(language).isNotNull();
    }
}