package com.cybertek.step_definitions;

import com.cybertek.pages.WikiSearchPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wiki_StepDefinitions {

    WikiSearchPage wikiSearchPage = new WikiSearchPage();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        String url = ConfigurationReader.getProperty("wikiUrl");
        Driver.getDriver().get(url);
    }

    @When("User types  {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String arg0) {
        wikiSearchPage.searchBox.sendKeys(arg0);
    }

    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikiSearchPage.searchButton.click();
    }

    @Then("User sees  {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String arg0) {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = arg0 + " - Wikipedia";

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("User sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String arg0) {
        String expectedHeader = arg0;
        String actualHeader = wikiSearchPage.mainHeader.getText();

        Assert.assertEquals(expectedHeader, actualHeader);
    }
}
