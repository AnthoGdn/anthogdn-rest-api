package fr.anthonygodin.api.cucumber.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import fr.anthonygodin.api.Application;
import fr.anthonygodin.api.domain.Level;
import fr.anthonygodin.api.domain.entity.Training;
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
 * Created by AnthoGdn on 26/03/17.
 */
@ContextConfiguration(classes = Application.class,
        initializers = ConfigFileApplicationContextInitializer.class)
public class TrainingsSteps extends AbstractSteps {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    @Given("^there are these trainings data in database:$")
    public void thereAreTheseTrainingsDataInDatabase(DataTable trainings) throws Throwable {
        List<Map<String, String>> maps = trainings.asMaps(String.class, String.class);
        maps.forEach(map -> {

            String id = map.get("id");
            String title = map.get("title");
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

            persistTraining(id, startDate, endDate, title, description, location, orderNb);
        });
    }

    @Given("^the trainings data database is:$")
    public void theTrainingsDatabaseIs(DataTable trainings) throws Throwable {
        List<Map<String, String>> maps = trainings.asMaps(String.class, String.class);

        boolean isCorrectTrainingTableSize = trainingTableSizeIs(maps.size());
        assertTrue(isCorrectTrainingTableSize);
        trainingTableIsCorrect(maps);
    }

    // PRIVATE
    private void persistTraining(
            String id, Date startDate, Date endDate,
            String title, String description, String location, int orderNb
    ) {
        Training training = new Training();

        training.setId(id);
        training.setStartDate(startDate);
        training.setEndDate(endDate);
        training.setTitle(title);
        training.setDescription(description);
        training.setLocation(location);
        training.setOrderNb(orderNb);

        entityManager.persist(training);
    }

    private boolean trainingTableSizeIs(long size) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(Training.class)));
        long sizeTrainingTable = entityManager.createQuery(cq).getSingleResult();
        return sizeTrainingTable == size;
    }

    private void trainingTableIsCorrect(List<Map<String, String>> maps) {
        maps.forEach(map -> {
            String id = map.get("id");
            String title = map.get("title");
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
                trainingIsInDatabase(startDate, endDate, title, description, location, orderNb);
            else
                trainingIsInDatabase(id, startDate, endDate, title, description, location, orderNb);
        });
    }

    private void trainingIsInDatabase(
            Date startDate, Date endDate,
            String title, String description, String location, int orderNb
    ) {
        Training training = entityManager.createQuery(
                "SELECT l FROM Training l WHERE " +
                        "l.startDate = :startDateL " +
                        "AND l.endDate = :endDateL " +
                        "AND l.title = :titleL " +
                        "AND l.description = :descriptionL " +
                        "AND l.location = :locationL " +
                        "AND l.orderNb = :orderNbL"
                , Training.class)

                .setParameter("titleL", title)
                .setParameter("descriptionL", description)
                .setParameter("locationL", location)
                .setParameter("orderNbL", orderNb)
                .getSingleResult();
        assertThat(training).isNotNull();
    }

    private void trainingIsInDatabase(
            String id, Date startDate, Date endDate,
            String title, String description, String location, int orderNb
    ) {
        Training training = entityManager.createQuery(
                "SELECT l FROM Training l WHERE " +
                        "l.id = :idL " +
                        "AND l.startDate = :startDateL " +
                        "AND l.endDate = :endDateL " +
                        "AND l.title = :titleL " +
                        "AND l.description = :descriptionL " +
                        "AND l.location = :locationL " +
                        "AND l.orderNb = :orderNbL"
                , Training.class)
                .setParameter("idL", id)
                .setParameter("startDateL", startDate)
                .setParameter("endDateL", endDate)
                .setParameter("titleL", title)
                .setParameter("descriptionL", description)
                .setParameter("locationL", location)
                .setParameter("orderNbL", orderNb)
                .getSingleResult();
        assertThat(training).isNotNull();
    }
}