package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.GWD;
import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;


public class _US04_TABMenu {

    DialogContent dc = new DialogContent();
    Actions actions = new Actions(GWD.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));


    @And("User hovers over the {string} category in the TAB menu")
    public void userHoversOverTheCategoryInTheTABMenu(String category) {
        actions.moveToElement(dc.getWebElement(category)).perform();
    }

    @Then("the {string} and {string} subcategories should be visible")
    public void theAndSubcategoriesShouldBeVisible(String subcategory1, String subcategory2) {
        assertTrue(dc.getWebElement(subcategory1).isDisplayed());
        assertTrue(dc.getWebElement(subcategory2).isDisplayed());
    }

    @When("the user clicks on the {string} subcategory")
    public void theUserClicksOnTheSubcategory(String subcategory) {
        dc.getWebElement(subcategory).click();
    }
    @Then("the user is redirected to a page showing products under the {string} subcategory")
    public void theUserIsRedirectedToAPageShowingProductsUnderTheSubcategory(String subcategory) {
        String expectedUrl = "";
        if (subcategory.equals("Tops")) {
            expectedUrl = "https://magento.softwaretestingboard.com/women/tops-women.html";
        } else if (subcategory.equals("Bottoms")) {
            expectedUrl = "https://magento.softwaretestingboard.com/men/bottoms-men.html";
        }
        assertTrue(GWD.getDriver().getCurrentUrl().equals(expectedUrl));
    }


    @When("the user clicks on the back button")
    public void theUserClicksOnTheBackButton() {
        dc.homeButton.click();
    }

    @And("the user hovers over the {string} category in the TAB menu")
    public void theUserHoversOverTheCategoryInTheTABMenu(String category) {
        actions.moveToElement(dc.getWebElement(category)).perform();

    }

}
