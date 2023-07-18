package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeSignedInPage {
    private final static By home = By.cssSelector("a[aria-label='Home']");
    private final WebDriver driver;
    private final WebDriverWait wait;

    public HomeSignedInPage(WebDriver driver) {
        this.driver = driver;
        // Defining Explicit Wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        waitForPageToLoad();
    }

    /**
     * This method verifies that home page has loaded by making sure that home button is displayed
     *
     * @return true if logged in and home button exists, false otherwise
     */
    public boolean verifyThatHomePageLoaded() {
        return driver.findElement(home).isDisplayed();
    }

    /**
     * This method waits for the page to load by waiting for signup button to be clickable
     */
    private void waitForPageToLoad() {
        wait.until(ExpectedConditions.elementToBeClickable(home));
    }
}
