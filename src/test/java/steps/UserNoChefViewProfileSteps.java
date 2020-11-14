package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserNoChefViewProfileSteps {
    WebDriver driver;
    @Given("the user wants to know more about a chef")
    public void theUserWantsToKnowAChef(){
        System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.navigate().to("https://homemadegg.herokuapp.com/");
    }

    @When("the user enters chef profile")
    public void userEntersUserProfile(){
        driver.findElement(By.id("profile_query")).sendKeys("profile");
    }

    @Then("the chef profile shows up")
    public void chefProfileShowsUp(){
        //Assert.assertEquals(driver.findElement(By.className("")).getText(), "\"PUBLICATIONS\"");
        System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.navigate().to("");
    }
}
