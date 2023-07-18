package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public final static String URL = "https://www.facebook.com/login/";
    private final static By emailContainer = By.id("email_container");
    private final static By loginButton = By.id("loginbutton");
    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // Defining Explicit Wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        waitForPageToLoad();
    }

    /**
     * This method returns the warning message
     *
     * @return warning message text
     */
    public String getWarningMessage() {
        return driver.findElement(emailContainer).getText();
    }

    /**
     * This method waits for the page to load by waiting for login button to be clickable
     */
    private void waitForPageToLoad() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
    }
}
