package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckpointPage {

    public static final String URL = "https://www.facebook.com/checkpoint/";
    private final static By pageHeader = By.cssSelector("span[dir='auto']");
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CheckpointPage(WebDriver driver) {
        this.driver = driver;
        // Defining Explicit Wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        waitForPageToLoad();
    }

    /**
     * This method returns the Header text
     *
     * @return header message text
     */
    public String getHeaderText() {
        return driver.findElement(pageHeader).getText();
    }

    private void waitForPageToLoad() {
        wait.until(ExpectedConditions.presenceOfElementLocated(pageHeader));
    }
}
