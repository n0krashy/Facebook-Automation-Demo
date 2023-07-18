package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeSignedOffPage {
    private final static By createAccountButton = By.cssSelector("a[data-testid='open-registration-form-button']");
    private final static By emailOrPhoneField = By.id("email");
    private final static By passwordField = By.id("pass");
    private final static By loginButton = By.name("login");


    private final WebDriver driver;
    private final WebDriverWait wait;

    public HomeSignedOffPage(WebDriver driver) {
        this.driver = driver;
        // Defining Explicit Wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        waitForPageToLoad();
    }

    /**
     * This method enters email or phone in its field during login
     *
     * @param emailOrPhone Email or phone to enter in login
     */
    public void enterEmailOrPhone(String emailOrPhone) {
        driver.findElement(emailOrPhoneField).sendKeys(emailOrPhone);
    }

    /**
     * This method enters password in its field during login
     *
     * @param password Password to enter in login
     */
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    /**
     * This method enters email and password and perform login
     *
     * @param email    Email to enter in login
     * @param password Password to enter in login
     */
    public void login(String email, String password) {
        enterEmailOrPhone(email);
        enterPassword(password);
        clickLogin();
    }

    /**
     * This method clicks on login button
     */
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    /**
     * This method clicks on sign up button
     */
    public SignupPage clickSignUp() {
        driver.findElement(createAccountButton).click();
        return new SignupPage(driver);
    }

    /**
     * This method waits for the page to load by waiting for login button to be clickable
     */
    private void waitForPageToLoad() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
    }

}
