package steps;

import com.acme.homemade.demo.domain.model.Publication;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PublicationSteps {

    Publication publication;
    String result;

    int amount = 3;

    @Test
    @Given("the user is in the index page")
    public void theUserIsInIndexPage() throws Throwable{
        publication = new Publication();
    }
    @Test
    @When("the user enters notifications in the notification icon where the number of new publications is (\\d+)$")
    public void userEnterNotificationsInTheNotificationsIcon() throws Throwable{
        //result = publication.getResults(this.amount);
       result = String.valueOf(amount);
    }
    @Test
    @Then("the results with publications appear")
    public void TheResultsWithPublicationsAppear() throws Throwable{
        Assertions.assertEquals(null, result);
    }
}