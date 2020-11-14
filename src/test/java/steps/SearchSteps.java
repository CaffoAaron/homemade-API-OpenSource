package steps;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class SearchSteps {
    WebDriver driver;

    @Test
    @Given("the user is in the index page")
    public void theUserIsInIndexPage(){
        System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.navigate().to("https://homemadegg.herokuapp.com/");
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
    public void recipesPage(){
        String title = driver.findElement(By.className("Nombre")).getText();
        Assert.assertEquals(title, "\"RECIPES\"");
    }
}