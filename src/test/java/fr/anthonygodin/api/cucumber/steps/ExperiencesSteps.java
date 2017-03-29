package fr.anthonygodin.api.cucumber.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import fr.anthonygodin.api.Application;
import fr.anthonygodin.api.domain.entity.Experience;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by AnthoGdn on 27/03/17.
 */
@ContextConfiguration(classes = Application.class,
        initializers = ConfigFileApplicationContextInitializer.class)
public class ExperiencesSteps extends AbstractSteps {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    @Given("^there are these experiences data in database:$")
    public void thereAreTheseExperiencesDataInDatabase(DataTable experiences) throws Throwable {
        List<Map<String, String>> maps = experiences.asMaps(String.class, String.class);
        maps.forEach(map -> {

            String id = map.get("id");
            String title = map.get("title");
            String languages = map.get("languages");
            String job = map.get("job");
            String description = map.get("description");
            String location = map.get("location");
            String orderNbString = map.get("orderNb");
            int orderNb = 0;
            if (orderNbString != null) {
                orderNb = Integer.valueOf(orderNbString);
            }
            String startDateString = map.get("startDate");
            String endDateString = map.get("endDate");
            Date startDate = null, endDate = null;
            try {
                startDate = format.parse(startDateString);
                endDate = format.parse(endDateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            persistExperience(id, startDate, endDate, title, languages, job, description, location, orderNb);
        });
    }

    @Given("^the experiences data database is:$")
    public void theExperiencesDatabaseIs(DataTable experiences) throws Throwable {
        List<Map<String, String>> maps = experiences.asMaps(String.class, String.class);

        boolean isCorrectExperienceTableSize = experienceTableSizeIs(maps.size());
        assertTrue(isCorrectExperienceTableSize);
        experienceTableIsCorrect(maps);
    }

    // PRIVATE
    private void persistExperience(
            String id, Date startDate, Date endDate,
            String title, String languages, String job, String description, String location, int orderNb
    ) {
        Experience experience = new Experience();

        experience.setId(id);
        experience.setStartDate(startDate);
        experience.setEndDate(endDate);
        experience.setTitle(title);
        experience.setLanguages(languages);
        experience.setJob(job);
        experience.setDescription(description);
        experience.setLocation(location);
        experience.setOrderNb(orderNb);

        entityManager.persist(experience);
    }

    private boolean experienceTableSizeIs(long size) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(Experience.class)));
        long sizeExperienceTable = entityManager.createQuery(cq).getSingleResult();
        return sizeExperienceTable == size;
    }

    private void experienceTableIsCorrect(List<Map<String, String>> maps) {
        maps.forEach(map -> {
            String id = map.get("id");
            String title = map.get("title");
            String languages = map.get("languages");
            String job = map.get("job");
            String description = map.get("description");
            String location = map.get("location");
            String orderNbString = map.get("orderNb");
            int orderNb = 0;
            if (orderNbString != null) {
                orderNb = Integer.valueOf(orderNbString);
            }
            String startDateString = map.get("startDate");
            String endDateString = map.get("endDate");
            Date startDate = null, endDate = null;
            try {
                startDate = format.parse(startDateString);
                endDate = format.parse(endDateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (id == null)
                experienceIsInDatabase(startDate, endDate, title, languages, job, description, location, orderNb);
            else
                experienceIsInDatabase(id, startDate, endDate, title, languages, job, description, location, orderNb);
        });
    }

    private void experienceIsInDatabase(
            Date startDate, Date endDate,
            String title, String languages, String job, String description, String location, int orderNb
    ) {
        Experience experience = entityManager.createQuery(
                "SELECT l FROM Experience l WHERE " +
                        "l.startDate = :startDateL " +
                        "AND l.endDate = :endDateL " +
                        "AND l.title = :titleL " +
                        "AND l.languages = :languagesL " +
                        "AND l.job = :jobL " +
                        "AND l.description = :descriptionL " +
                        "AND l.location = :locationL " +
                        "AND l.orderNb = :orderNbL"
                , Experience.class)

                .setParameter("titleL", title)
                .setParameter("languagesL", languages)
                .setParameter("jobL", job)
                .setParameter("descriptionL", description)
                .setParameter("locationL", location)
                .setParameter("orderNbL", orderNb)
                .getSingleResult();
        assertThat(experience).isNotNull();
    }

    private void experienceIsInDatabase(
            String id, Date startDate, Date endDate,
            String title, String languages, String job, String description, String location, int orderNb
    ) {
        Experience experience = entityManager.createQuery(
                "SELECT l FROM Experience l WHERE " +
                        "l.id = :idL " +
                        "AND l.startDate = :startDateL " +
                        "AND l.endDate = :endDateL " +
                        "AND l.title = :titleL " +
                        "AND l.languages = :languagesL " +
                        "AND l.job = :jobL " +
                        "AND l.description = :descriptionL " +
                        "AND l.location = :locationL " +
                        "AND l.orderNb = :orderNbL"
                , Experience.class)
                .setParameter("idL", id)
                .setParameter("startDateL", startDate)
                .setParameter("endDateL", endDate)
                .setParameter("titleL", title)
                .setParameter("languagesL", languages)
                .setParameter("jobL", job)
                .setParameter("descriptionL", description)
                .setParameter("locationL", location)
                .setParameter("orderNbL", orderNb)
                .getSingleResult();
        assertThat(experience).isNotNull();
    }
}