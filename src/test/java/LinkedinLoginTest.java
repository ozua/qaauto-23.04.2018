import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before(){
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");
    }

    @Test
    public void successfulLoginTest() throws InterruptedException {
        String actualLoginPageTitle = webDriver.getTitle();

        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page title is wrong");

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage();
        linkedInLoginPage.login("erik.mouwes@gmail.com", "vlttar54");

        Assert.assertTrue(submitButton.isDisplayed(), "Sign In button is not displayed");

        Assert.assertEquals(webDriver.getTitle(), "LinkedIn", "Homepage is not LinkedIn.com");
        String actualHomePageTitle = webDriver.getTitle();
        Assert.assertNotEquals(actualLoginPageTitle, actualHomePageTitle, "Page title did not change after Sign In");
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Homepage url is wrong.");
    }

    @Test
    public void negativeLoginTest() throws InterruptedException {
        String actualLoginPageTitle = webDriver.getTitle();

        Assert.assertEquals(actualLoginPageTitle, "LinkedIn: Log In or Sign Up", "Login page is wrong");

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage();
        linkedInLoginPage.login("erik.mouwes@gmail.com", "4");

        sleep(3000);

        String currentPageUrl = webDriver.getCurrentUrl();
        String currentPageTitle = webDriver.getTitle();

        Assert.assertEquals(currentPageUrl, "https://www.linkedin.com/uas/login-submit", "Login-submit page is wrong");
        Assert.assertEquals(currentPageTitle, "Войти в LinkedIn", "Login-Submit page title is wrong");

        WebElement errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));

        Assert.assertEquals(errorMessage.getText(), "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.", "Wrong error message text displayed");
    }

    @AfterMethod
    public void atfer() {
        webDriver.close();
    }

}
