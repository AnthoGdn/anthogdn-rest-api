package fr.anthonygodin.api.cucumber.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import fr.anthonygodin.api.Application;
import fr.anthonygodin.api.domain.entity.Language;
import fr.anthonygodin.api.dto.entity.LanguageDTO;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Map;

/**
 * Created by AnthoGdn on 18/03/17.
 */
@ContextConfiguration(classes = Application.class,
        initializers = ConfigFileApplicationContextInitializer.class)
public class LanguagesSteps extends AbstractSteps {

    @Given("^there are these languages data in database:$")
    public void thereAreTheseDiariesDataInDatabase(DataTable languages) throws Throwable {
        List<Map<String, String>> maps = languages.asMaps(String.class, String.class);
        maps.forEach(map -> {
            LanguageDTO language = new LanguageDTO();
            String id = map.get("id");
            String name = map.get("name");
            String url = map.get("url");
            Language.Level level = Language.Level.valueOf(map.get("level"));
            String orderNbString = map.get("orderNb");
            int orderNb = 0;
            if (orderNbString != null) {
                orderNb = Integer.valueOf(orderNbString);
            }

            persistLanguage(null, name, level, url, orderNb);
        });
    }

    // PRIVATE
    private void persistLanguage(String id, String name, Language.Level level, String url, int orderNb) {
        Language language = new Language();

        language.setName(name);
        language.setImgURL(url);
        language.setLevel(level);
        language.setOrderNb(orderNb);

        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println(language);

        entityManager.persist(language);
    }
}