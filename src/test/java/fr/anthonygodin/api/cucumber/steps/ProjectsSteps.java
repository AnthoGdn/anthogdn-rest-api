package fr.anthonygodin.api.cucumber.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import fr.anthonygodin.api.Application;
import fr.anthonygodin.api.domain.entity.Project;
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
public class ProjectsSteps extends AbstractSteps {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    @Given("^there are these projects data in database:$")
    public void thereAreTheseProjectsDataInDatabase(DataTable projects) throws Throwable {
        List<Map<String, String>> maps = projects.asMaps(String.class, String.class);
        maps.forEach(map -> {

            String id = map.get("id");
            String title = map.get("title");
            String languages = map.get("languages");
            String job = map.get("job");
            String partnerTeamNbString = map.get("partnerTeamNb");
            int partnerTeamNb = Integer.valueOf(partnerTeamNbString);
            String description = map.get("description");
            String location = map.get("location");
            String orderNbString = map.get("orderNb");
            int orderNb = Integer.valueOf(orderNbString);
            String startDateString = map.get("startDate");
            String endDateString = map.get("endDate");
            Date startDate = null, endDate = null;
            try {
                startDate = format.parse(startDateString);
                endDate = format.parse(endDateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            persistProject(id, startDate, endDate, title, languages, partnerTeamNb, job, description, location, orderNb);
        });
    }

    @Given("^the projects data database is:$")
    public void theProjectsDatabaseIs(DataTable projects) throws Throwable {
        List<Map<String, String>> maps = projects.asMaps(String.class, String.class);

        boolean isCorrectProjectTableSize = projectTableSizeIs(maps.size());
        assertTrue(isCorrectProjectTableSize);
        projectTableIsCorrect(maps);
    }

    // PRIVATE
    private void persistProject(
            String id, Date startDate, Date endDate,
            String title, String languages, int partnerTeamNb, String job, String description, String location, int orderNb
    ) {
        Project project = new Project();

        project.setId(id);
        project.setStartDate(startDate);
        project.setEndDate(endDate);
        project.setTitle(title);
        project.setLanguages(languages);
        project.setPartnerTeamNb(partnerTeamNb);
        project.setJob(job);
        project.setDescription(description);
        project.setLocation(location);
        project.setOrderNb(orderNb);

        entityManager.persist(project);
    }

    private boolean projectTableSizeIs(long size) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(Project.class)));
        long sizeProjectTable = entityManager.createQuery(cq).getSingleResult();
        return sizeProjectTable == size;
    }

    private void projectTableIsCorrect(List<Map<String, String>> maps) {
        maps.forEach(map -> {
            String id = map.get("id");
            String title = map.get("title");
            String languages = map.get("languages");
            String partnerTeamNbString = map.get("partnerTeamNb");
            int partnerTeamNb = Integer.valueOf(partnerTeamNbString);
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
                projectIsInDatabase(startDate, endDate, title, languages, partnerTeamNb, job, description, location, orderNb);
            else
                projectIsInDatabase(id, startDate, endDate, title, languages, partnerTeamNb, job, description, location, orderNb);
        });
    }

    private void projectIsInDatabase(
            Date startDate, Date endDate,
            String title, String languages, int partnerTeamNb, String job, String description, String location, int orderNb
    ) {
        Project project = entityManager.createQuery(
                "SELECT l FROM Project l WHERE " +
                        "l.startDate = :startDateL " +
                        "AND l.endDate = :endDateL " +
                        "AND l.title = :titleL " +
                        "AND l.languages = :languagesL " +
                        "AND l.partnerTeamNb = :partnerTeamNbL " +
                        "AND l.job = :jobL " +
                        "AND l.description = :descriptionL " +
                        "AND l.location = :locationL " +
                        "AND l.orderNb = :orderNbL"
                , Project.class)
                .setParameter("titleL", title)
                .setParameter("languagesL", languages)
                .setParameter("partnerTeamNbL", partnerTeamNb)
                .setParameter("jobL", job)
                .setParameter("descriptionL", description)
                .setParameter("locationL", location)
                .setParameter("orderNbL", orderNb)
                .getSingleResult();
        assertThat(project).isNotNull();
    }

    private void projectIsInDatabase(
            String id, Date startDate, Date endDate,
            String title, String languages, int partnerTeamNb, String job, String description, String location, int orderNb
    ) {
        Project project = entityManager.createQuery(
                "SELECT l FROM Project l WHERE " +
                        "l.id = :idL " +
                        "AND l.startDate = :startDateL " +
                        "AND l.endDate = :endDateL " +
                        "AND l.title = :titleL " +
                        "AND l.languages = :languagesL " +
                        "AND l.partnerTeamNb = :partnerTeamNbL " +
                        "AND l.job = :jobL " +
                        "AND l.description = :descriptionL " +
                        "AND l.location = :locationL " +
                        "AND l.orderNb = :orderNbL"
                , Project.class)
                .setParameter("idL", id)
                .setParameter("startDateL", startDate)
                .setParameter("endDateL", endDate)
                .setParameter("titleL", title)
                .setParameter("languagesL", languages)
                .setParameter("partnerTeamNbL", partnerTeamNb)
                .setParameter("jobL", job)
                .setParameter("descriptionL", description)
                .setParameter("locationL", location)
                .setParameter("orderNbL", orderNb)
                .getSingleResult();
        assertThat(project).isNotNull();
    }
}