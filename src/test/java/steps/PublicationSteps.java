package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PublicationSteps {
    WebDriver driver;
    @Given("the user is in the index page")
    public void theUserIsInIndexPage(){
        System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.navigate().to("https://homemadegg.herokuapp.com/");
    }

    @When("the user enters notifications in the notification icon")
    public void userEnterNotificationsInTheNotificationsIcon(){
        driver.findElement(By.id("notification_query_top")).sendKeys("notifications");
    }

    @Then("the results with publications appear")
    public void TheResultsWithPublicationsAppear(){
        Assert.assertEquals(driver.findElement(By.className("")).getText(), "\"PUBLICATIONS\"");
    }
}