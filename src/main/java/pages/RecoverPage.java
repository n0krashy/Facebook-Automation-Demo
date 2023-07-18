package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecoverPage {
    public final static String URL = "https://www.facebook.com/recover/initiate/";
    private final static By errorMessage = By.cssSelector(".pam.uiBoxGray");
    private final static By continueButton = By.xpath("//button[text()='Continue']");
    private final WebDriver driver;
    private final WebDriverWait wait;

    public RecoverPage(WebDriver driver) {
        this.driver = driver;
        // Defining Explicit Wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        waitForPageToLoad();
    }

    /**
     * This method returns the error message
     *
     * @return error message text
     */
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    /**
     * This method waits for the page to load by waiting for login button to be clickable
     */
    private void waitForPageToLoad() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
    }

}