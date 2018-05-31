package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LinkedInLoginPage;


public class LinkedInBaseTest {
    LinkedInLoginPage linkedInLoginPage;
    WebDriver webDriver;

    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");
        linkedInLoginPage = new LinkedInLoginPage(webDriver);
    }

    @AfterMethod
    public void atfer() {
        webDriver.close();
    }

}
