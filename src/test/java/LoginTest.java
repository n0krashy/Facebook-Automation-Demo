import core.PagesHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomeSignedInPage;
import pages.HomeSignedOffPage;
import pages.LoginPage;
import pages.RecoverPage;

public class LoginTest {
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
    @Parameters({"email", "password"})
    public void validLogin(String email, String password) {
        HomeSignedOffPage homeSignedOffPage = new HomeSignedOffPage(driver);
        homeSignedOffPage.login(email, password);
        HomeSignedInPage homeSignedInPage = new HomeSignedInPage(driver);
        Assert.assertTrue(homeSignedInPage.verifyThatHomePageLoaded());
    }

    @Test
    @Parameters({"email", "invalidPassword"})
    public void invalidPasswordLogin(String email, String password) {
        HomeSignedOffPage homeSignedOffPage = new HomeSignedOffPage(driver);
        homeSignedOffPage.login(email, password);
        RecoverPage recoverPage = new RecoverPage(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains(RecoverPage.URL));
        Assert.assertEquals(recoverPage.getErrorMessage(), "The password you've entered is incorrect.");
    }

    @Test
    @Parameters({"invalidEmail", "password"})
    public void invalidEmailLogin(String email, String password) {
        HomeSignedOffPage homeSignedOffPage = new HomeSignedOffPage(driver);
        homeSignedOffPage.login(email, password);
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains(LoginPage.URL));
        Assert.assertEquals(loginPage.getWarningMessage(), "The email address you entered isn't connected to an account. Find your account and log in.");
    }

    @Test
    public void emptyInfoLogin() {
        HomeSignedOffPage homeSignedOffPage = new HomeSignedOffPage(driver);
        homeSignedOffPage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains(LoginPage.URL));
        Assert.assertEquals(loginPage.getWarningMessage(), "The email address or mobile number you entered isn't connected to an account. Find your account and log in.");
    }
}
