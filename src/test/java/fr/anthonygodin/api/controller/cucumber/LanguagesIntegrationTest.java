package fr.anthonygodin.api.controller.cucumber;

import fr.anthonygodin.api.controller.cucumber.utils.SpringIntegrationTest;
import org.springframework.http.HttpStatus;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LanguagesIntegrationTest extends SpringIntegrationTest {

    @When("^the client calls /languages$")
    public void the_client_issues_GET_languages() throws Throwable {
        executeGet("http://localhost:8080/api/languages");
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @And("^the client receives server version (.+)$")
    public void the_client_receives_server_version_body(String version) throws Throwable {
        assertThat(latestResponse.getBody(), is(version));
    }
}