package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefix.FirefoxDriver;

import cubumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchSteps {
    WebDriver driver;
    @Given("the user is in the index page")
    public void theUserIsInIndexPage(){
        System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.navigate().to("");
    }

    @When("the user enters recipes in the search bar")
    public void userEnterRecipesInSearchBar(){
        driver.findElement(By.id("search_query_top")).sendKeys("recipes");
    }
    @When("the user clicks the search button")
    public void userClicksSearchButton(){
        driver.findElement(By.name("submit_search")).click();
    }

    @Then("the results with recipes appear")
    public void dressesPage(){
        Assert.assertEquals(driver.findElement(By.classname("")).getText(), "\"RECIPES\"");
    }
}
