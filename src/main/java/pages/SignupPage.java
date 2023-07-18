package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {
    private final static By signupButton = By.name("websubmit");
    private final static By firstNameField = By.name("firstname");
    private final static By lastNameField = By.name("lastname");
    private final static By mobileOrEmailField = By.name("reg_email__");
    private final static By mobileOrEmailConfirmField = By.name("reg_email_confirmation__");
    private final static By passwordField = By.id("password_step_input");
    private final static By daySelector = By.id("day");
    private final static By monthSelector = By.id("month");
    private final static By yearSelector = By.id("year");
    private final static By femaleSelector = By.cssSelector("input[name='sex'][value='1']");
    private final static By maleSelector = By.cssSelector("input[name='sex'][value='2']");
    private final static String URL = "https://www.facebook.com/";
    private final WebDriver driver;
    private final WebDriverWait wait;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        // Defining Explicit Wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        waitForPageToLoad();
    }

    /**
     * This method enters first name in its field during registration
     *
     * @param name First name to enter in registration
     */
    public void enterFirstName(String name) {
        driver.findElement(firstNameField).sendKeys(name);
    }

    /**
     * This method enters last name in its field during registration
     *
     * @param name Last name to enter in registration
     */
    public void enterLastName(String name) {
        driver.findElement(lastNameField).sendKeys(name);
    }

    /**
     * This method enters email or phone in its field during registration
     *
     * @param emailOrPhone Email or phone to enter in registration
     */
    public void enterEmailOrPhone(String emailOrPhone) {
        driver.findElement(mobileOrEmailField).sendKeys(emailOrPhone);
        confirmEmailOrPhone(emailOrPhone);
    }

    /**
     * This method enters email or phone in its confirmation field during registration
     *
     * @param emailOrPhone Email or phone to enter in registration
     */
    public void confirmEmailOrPhone(String emailOrPhone) {
        driver.findElement(mobileOrEmailConfirmField).sendKeys(emailOrPhone);
    }

    /**
     * This method enters password in its field during registration
     *
     * @param password Password to enter in registration
     */
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    /**
     * This method chooses gender during registration
     *
     * @param male if male is true, it will select a male gender, otherwise it will select female
     */
    public void chooseGender(boolean male) {
        if (male)
            driver.findElement(maleSelector).click();
        else
            driver.findElement(femaleSelector).click();
    }

    /**
     * This method selects the birthdate during registration
     *
     * @param day   day of birth
     * @param month month of birth
     * @param year  year of birth
     */
    public void selectBirthDate(int day, int month, int year) {
        Select drpDay = new Select(driver.findElement(daySelector));
        Select drpMonth = new Select(driver.findElement(monthSelector));
        Select drpYear = new Select(driver.findElement(yearSelector));
        drpDay.selectByValue(Integer.toString(day));
        drpMonth.selectByValue(Integer.toString(month));
        drpYear.selectByValue(Integer.toString(year));
    }

    /**
     * This method do sign up with the passed info
     */
    public void signup(String firstName, String lastName, String email, String password, boolean male, int day, int month, int year) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmailOrPhone(email);
        enterPassword(password);
        chooseGender(male);
        selectBirthDate(day, month, year);
        clickSignUp();
        waitForNextPageToStartLoading();
    }

    public void waitForNextPageToStartLoading() {
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(URL)));
    }

    /**
     * This method clicks on sign up button during registration
     */
    public void clickSignUp() {
        driver.findElement(signupButton).click();
    }

    /**
     * This method waits for the page to load by waiting for signup button to be clickable
     */
    private void waitForPageToLoad() {
        wait.until(ExpectedConditions.elementToBeClickable(signupButton));
    }

}
