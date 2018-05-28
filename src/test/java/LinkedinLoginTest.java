import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before(){
        webDriver = new FirefoxDriver();
       // webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://www.linkedin.com/");
    }

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "erik.mouwes@gmail.com", "vlttar54" },
                { "ERIK.MOUWES@GMAIL.COM", "vlttar54" }
        };
    }

    @DataProvider
    public Object[][] emptyFieldsDataProvider() {
        return new Object[][]{
                { "", "" },
                { "", "vlttar54" },
                { "", "4" },
                { "erik.mouwes@gmail.com", "" }
        };
    }

    @DataProvider
    public Object[][] invalidDataProvider() {
        return new Object[][]{
                { "invalid@gil.com", "vlttar54" },
                { "invalid@gil.com", "invalidpass" },
                { "invalid@gil.com", "4" },
                { "erik.mouwes@gmail.com", "invalidpass" },
                { "erik.mouwes@gmail.com", "4" }
        };
    }

    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String email, String password) throws InterruptedException {
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(webDriver);

        Assert.assertEquals(linkedInLoginPage.getCurrentTitle(), "LinkedIn: Log In or Sign Up", "Login page title is wrong");
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login(email, password);

        //sleep(5000);

        Assert.assertTrue(linkedInHomePage.getCurrentTitle().contains("LinkedIn"), "Page title did not change after Sign In");
        Assert.assertEquals(linkedInHomePage.getCurrentUrl(), "https://www.linkedin.com/feed/", "Homepage url is wrong.");
    }

    @Test(dataProvider = "invalidDataProvider")
    public void negativeReturnedToLoginSubmitTest(String email, String password) throws InterruptedException {
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(webDriver);

        Assert.assertEquals(linkedInLoginPage.getCurrentTitle(), "LinkedIn: Log In or Sign Up", "Login page title is wrong");
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

        LinkedInFailedLoginPage linkedInFailedLoginPage = linkedInLoginPage.login(email, password);

        //sleep(5000);

        Assert.assertTrue(linkedInFailedLoginPage.isPageLoaded(),  "Wrong login submit page loaded");
        Assert.assertEquals(linkedInFailedLoginPage.getErrorMessageText(), "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.", "Wrong error message text displayed");
    }

    @Test(dataProvider = "emptyFieldsDataProvider")
    public void negativeLoginTestWithEmptyLoginAndPasswordFields(String email, String password) throws InterruptedException {
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(webDriver);

        Assert.assertEquals(linkedInLoginPage.getCurrentTitle(), "LinkedIn: Log In or Sign Up", "Login page title is wrong");
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

        //LinkedInLoginPage linkedInLoginPage = linkedInLoginPage.(email, password);

        //sleep(5000);

        Assert.assertEquals(linkedInLoginPage.getCurrentTitle(), "LinkedIn: Log In or Sign Up", "Login page title is wrong");
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");
    }

    @AfterMethod
    public void atfer() {
        webDriver.close();
    }

}
