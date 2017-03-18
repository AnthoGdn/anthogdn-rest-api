package fr.anthonygodin.api.cucumber.steps;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

/**
 * Created by AnthoGdn on 18/03/17.
 */
@WebAppConfiguration
@RunWith(Cucumber.class)
@Transactional
public abstract class AbstractSteps {

    @Autowired
    WebApplicationContext context;

    @Autowired
    DataSource dataSource;

    @PersistenceContext
    EntityManager entityManager;
}
