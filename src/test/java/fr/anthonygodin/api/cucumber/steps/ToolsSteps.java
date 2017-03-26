package fr.anthonygodin.api.cucumber.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import fr.anthonygodin.api.Application;
import fr.anthonygodin.api.domain.entity.Tool;
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
public class ToolsSteps extends AbstractSteps {

    @Given("^there are these tools data in database:$")
    public void thereAreTheseToolsDataInDatabase(DataTable tools) throws Throwable {
        List<Map<String, String>> maps = tools.asMaps(String.class, String.class);
        maps.forEach(map -> {
            String id = map.get("id");
            String name = map.get("name");
            String url = map.get("url");
            Tool.Level level = Tool.Level.valueOf(map.get("level"));
            String orderNbString = map.get("orderNb");
            int orderNb = 0;
            if (orderNbString != null) {
                orderNb = Integer.valueOf(orderNbString);
            }

            persistTool(id, name, level, url, orderNb);
        });
    }

    @Given("^the tools data database is:$")
    public void theToolsDatabaseIs(DataTable tools) throws Throwable {
        List<Map<String, String>> maps = tools.asMaps(String.class, String.class);

        boolean isCorrectToolTableSize = toolTableSizeIs(maps.size());
        assertTrue(isCorrectToolTableSize);
        toolTableIscorrect(maps);
    }

    // PRIVATE
    private void persistTool(String id, String name, Tool.Level level, String url, int orderNb) {
        Tool tool = new Tool();

        tool.setId(id);
        tool.setName(name);
        tool.setImgURL(url);
        tool.setLevel(level);
        tool.setOrderNb(orderNb);

        entityManager.persist(tool);
    }

    private boolean toolTableSizeIs(long size) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(Tool.class)));
        long sizeToolTable = entityManager.createQuery(cq).getSingleResult();
        return sizeToolTable == size;
    }

    private void toolTableIscorrect(List<Map<String, String>> maps) {
        maps.forEach(map -> {
            String id = map.get("id");
            String name = map.get("name");
            String url = map.get("url");
            Tool.Level level = Tool.Level.valueOf(map.get("level"));

            String orderNbString = map.get("orderNb");
            int orderNb = 0;
            if (orderNbString != null) {
                orderNb = Integer.valueOf(orderNbString);
            }
            if (id == null)
                toolIsInDatabase(name, level, url, orderNb);
            else
                toolIsInDatabase(id, name, level, url, orderNb);
        });
    }

    private void toolIsInDatabase(String name, Tool.Level level, String url, int orderNb) {
        Tool tool = entityManager.createQuery(
                "SELECT l FROM Tool l WHERE " +
                        "l.name = :nameL AND l.level = :levelL AND l.imgURL = :urlL AND l.orderNb = :orderNbL"
                , Tool.class)
                .setParameter("nameL", name)
                .setParameter("levelL", level)
                .setParameter("urlL", url)
                .setParameter("orderNbL", orderNb)
                .getSingleResult();
        assertThat(tool).isNotNull();
    }

    private void toolIsInDatabase(String id, String name, Tool.Level level, String url, int orderNb) {
        Tool tool = entityManager.createQuery(
                "SELECT l FROM Tool l WHERE " +
                        "l.id = :idL AND l.name = :nameL AND l.level = :levelL AND l.imgURL = :urlL AND l.orderNb = :orderNbL"
                , Tool.class)
                .setParameter("idL", id)
                .setParameter("nameL", name)
                .setParameter("levelL", level)
                .setParameter("urlL", url)
                .setParameter("orderNbL", orderNb)
                .getSingleResult();
        assertThat(tool).isNotNull();
    }
}