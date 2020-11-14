package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserChefViewProfileSteps {
    WebDriver driver;
    @Given("the chef wants to know more about a user")
    public void theChefWantsToKnowAUser(){
        System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.navigate().to("https://homemadegg.herokuapp.com/");
    }

    @When("the chef enters user profile")
    public void chefEntersUserProfile(){
        driver.findElement(By.id("profile_query")).sendKeys("profile");
    }

    @Then("the user profile shows up")
    public void userProfileShowsUp(){
        //Assert.assertEquals(driver.findElement(By.className("")).getText(), "\"PUBLICATIONS\"");
        System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.navigate().to("");
    }
}
