package fr.anthonygodin.api.cucumber.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import fr.anthonygodin.api.Application;
import fr.anthonygodin.api.domain.entity.Interest;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by AnthoGdn on 26/03/17.
 */
@ContextConfiguration(classes = Application.class,
        initializers = ConfigFileApplicationContextInitializer.class)
public class InterestsSteps extends AbstractSteps {

    @Given("^there are these interests data in database:$")
    public void thereAreTheseInterestsDataInDatabase(DataTable interests) throws Throwable {
        List<Map<String, String>> maps = interests.asMaps(String.class, String.class);
        maps.forEach(map -> {
            String id = map.get("id");
            String name = map.get("name");
            String url = map.get("url");
            String type = map.get("type");
            String orderNbString = map.get("orderNb");
            int orderNb = 0;
            if (orderNbString != null) {
                orderNb = Integer.valueOf(orderNbString);
            }

            persistInterest(id, name, url, type, orderNb);
        });
    }

    @Given("^the interests data database is:$")
    public void theInterestsDatabaseIs(DataTable interests) throws Throwable {
        List<Map<String, String>> maps = interests.asMaps(String.class, String.class);

        boolean isCorrectInterestTableSize = interestTableSizeIs(maps.size());
        assertTrue(isCorrectInterestTableSize);
        interestTableIsCorrect(maps);
    }

    // PRIVATE
    private void persistInterest(
            String id, String name, String url, String type, int orderNb
    ) {
        Interest interest = new Interest();

        interest.setId(id);
        interest.setName(name);
        interest.setImgURL(url);
        interest.setType(type);
        interest.setOrderNb(orderNb);

        entityManager.persist(interest);
    }

    private boolean interestTableSizeIs(long size) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(Interest.class)));
        long sizeInterestTable = entityManager.createQuery(cq).getSingleResult();
        return sizeInterestTable == size;
    }

    private void interestTableIsCorrect(List<Map<String, String>> maps) {
        maps.forEach(map -> {
            String id = map.get("id");
            String name = map.get("name");
            String url = map.get("url");
            String type = map.get("type");

            String orderNbString = map.get("orderNb");
            int orderNb = 0;
            if (orderNbString != null) {
                orderNb = Integer.valueOf(orderNbString);
            }
            if (id == null)
                interestIsInDatabase(name, url, type, orderNb);
            else
                interestIsInDatabase(id, name, url, type, orderNb);
        });
    }

    private void interestIsInDatabase(String name, String url, String type, int orderNb) {
        Interest interest = entityManager.createQuery(
                "SELECT l FROM Interest l WHERE " +
                        "l.name = :nameL " +
                        "AND l.imgURL = :urlL " +
                        "AND l.type = :typeL " +
                        "AND l.orderNb = :orderNbL"
                , Interest.class)
                .setParameter("nameL", name)
                .setParameter("urlL", url)
                .setParameter("typeL", type)
                .setParameter("orderNbL", orderNb)
                .getSingleResult();
        assertThat(interest).isNotNull();
    }

    private void interestIsInDatabase(
            String id, String name, String url, String type, int orderNb
    ) {
        Interest interest = entityManager.createQuery(
                "SELECT l FROM Interest l WHERE " +
                        "l.id = :idL " +
                        "AND l.name = :nameL " +
                        "AND l.imgURL = :urlL " +
                        "AND l.type = :typeL " +
                        "AND l.orderNb = :orderNbL"
                , Interest.class)
                .setParameter("idL", id)
                .setParameter("nameL", name)
                .setParameter("urlL", url)
                .setParameter("typeL", type)
                .setParameter("orderNbL", orderNb)
                .getSingleResult();
        assertThat(interest).isNotNull();
    }
}