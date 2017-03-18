package fr.anthonygodin.api.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources")
/**
 * Created by AnthoGdn on 18/03/17.
 */
public class CucumberIntegrationTest {
}