package core;

import org.openqa.selenium.WebDriver;

public class PagesHelper {
    WebDriver driver;

    public PagesHelper(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver initiate() {
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        return driver;
    }
}
