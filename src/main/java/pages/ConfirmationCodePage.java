package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationCodePage {
    public final static String URL = "https://www.facebook.com/confirmemail";
    private final static By codeField = By.id("recovery_code_entry");
    private final static By continueButton = By.cssSelector("button[name='reset_action']");
    private final static By errorBox = By.id("error_box");
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ConfirmationCodePage(WebDriver driver) {
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
        return driver.findElement(errorBox).findElement(By.tagName("div")).getText();
    }

    /**
     * This method enters code in its field during registration
     *
     * @param code Code to enter in registration
     */
    public void enterCode(String code) {
        driver.findElement(codeField).sendKeys(code);
    }

    /**
     * This method clicks on continue button during registration
     */
    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    /**
     * This method waits for the page to load by waiting for code field to be present
     */
    private void waitForPageToLoad() {
        wait.until(ExpectedConditions.presenceOfElementLocated(codeField));
    }
}
