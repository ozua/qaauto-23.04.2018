package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.LinkedInLoginPage;

/**
 * BaseTest object class
 */
public class LinkedInBaseTest {
    LinkedInLoginPage linkedInLoginPage;
    WebDriver webDriver;

    @Parameters({"browserType", "envURL"})

    @BeforeMethod
    public void beforeTest(@Optional("chrome") String browserType,
                           @Optional("https://linkedin.com/") String envURL) {

        switch (browserType.toLowerCase()){
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            default :
                WebDriverManager.iedriver().setup();
                webDriver = new InternetExplorerDriver();
        }

        webDriver.navigate().to(envURL);
        linkedInLoginPage = new LinkedInLoginPage(webDriver);
    }

    @AfterMethod
    public void atfer() {
        webDriver.close();
    }

}
