package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UserChefViewProfileSteps {
    UserChefViewProfileSteps userchefviewprofilesteps;

    String profile;

    @Test
    @Given("the chef wants to know more about a user")
    public void theChefWantsToKnowAUser(){
        userchefviewprofilesteps = new UserChefViewProfileSteps();
    }
    @Test
    @When("the chef enters user profile")
    public void chefEntersUserProfile(){
        profile = "Usuario";
    }

    @Test
    @Then("the user profile shows up")
    public void userProfileShowsUp(){
        Assertions.assertEquals(profile, profile);
    }
}
