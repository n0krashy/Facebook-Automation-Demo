import core.PagesHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CheckpointPage;
import pages.HomeSignedOffPage;
import pages.SignupPage;

public class SignupTest {
    static PagesHelper pagesHelper;
    private static WebDriver driver;

    /**
     * Opens a new Chrome browser for each test method
     */
    @BeforeMethod
    public static void beforeMethod() {
        driver = new ChromeDriver();
        pagesHelper = new PagesHelper(driver);
        driver = pagesHelper.initiate();
    }

    /**
     * Quit the driver after finishing all the test cases
     */
    @AfterSuite
    public static void afterSuite() {
        driver.quit();
    }

    /**
     * Closes the driver window after finishing each test method
     */
    @AfterMethod
    public void after() {
        driver.close();
    }

    @Test
    @Parameters({"firstName", "lastName", "email", "password", "male", "day", "month", "year"})
    public void validSignup(String firstName, String lastName, String email, String password, boolean male, int day, int month, int year) {
        HomeSignedOffPage homeSignedOffPage = new HomeSignedOffPage(driver);
        SignupPage signupPage = homeSignedOffPage.clickSignUp();
        signupPage.signup(firstName, lastName, email, password, male, day, month, year);
        new CheckpointPage(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains(CheckpointPage.URL));
    }
}
