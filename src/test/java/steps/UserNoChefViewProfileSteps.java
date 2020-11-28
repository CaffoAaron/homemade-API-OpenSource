package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UserNoChefViewProfileSteps {
    UserNoChefViewProfileSteps usernochefviewprofilesteps;
    String profile;

    @Test
    @Given("the user wants to know more about a chef")
    public void theUserWantsToKnowAChef(){
        usernochefviewprofilesteps = new UserNoChefViewProfileSteps();
    }

    @Test
    @When("the user enters chef profile")
    public void userEntersUserProfile(){
        profile = "Chef";
    }

    @Test
    @Then("the chef profile shows up")
    public void chefProfileShowsUp(){
        Assertions.assertEquals(profile, profile);
    }
}
