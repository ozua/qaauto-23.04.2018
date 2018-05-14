import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {

    @Test
    public void successfulLoginTest() throws InterruptedException {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");

        String actualLoginPageTitle = webDriver.getTitle();

        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page is wrong");

        WebElement inputLogin = webDriver.findElement(By.id("login-email"));
        WebElement inputPassword = webDriver.findElement(By.id("login-password"));

        WebElement submitButton = webDriver.findElement(By.xpath("//input[@class='login submit-button']"));
        Assert.assertTrue(submitButton.isDisplayed(), "Sign In button is not displayed");

        //Negative 1 (empty fields)

        inputLogin.sendKeys( "");
        inputPassword.sendKeys( "");

        submitButton.click();

        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page is wrong");

        sleep(5000);

        //Negative 2 (empty login field and wrong pass field)

        inputLogin.sendKeys( "");
        inputPassword.sendKeys( "wrongPass01");

        submitButton.click();

        sleep(5000);

        //Negative 3 (empty login field and correct pass field)

        inputLogin.sendKeys( "");
        inputPassword.clear();
        inputPassword.sendKeys( "vlttar54");

        submitButton.click();

        sleep(5000);

        //Negative 4 (wrong login field and empty pass field)

        inputLogin.sendKeys( "wrongLogin@gmail.com");
        inputPassword.sendKeys( "");

        WebElement submitButtonPrimary = webDriver.findElement(By.xpath("//input[@class='btn-primary']"));
        Assert.assertTrue(submitButtonPrimary.isDisplayed(), "Sign In button is not displayed");

        submitButtonPrimary.click();

        sleep(5000);

        //Negative 5 (wrong login field and wrong pass field)

        inputLogin.sendKeys( "wrongLogin@gmail.com");
        inputPassword.sendKeys( "wrongPass01");

        submitButtonPrimary.click();

        sleep(5000);

        //Negative 6 (wrong login field and correct pass field)

        inputLogin.sendKeys( "wrongLogin@gmail.com");
        inputPassword.sendKeys( "vlttar54");

        submitButtonPrimary.click();

        sleep(5000);

        //Negative 7 (correct login field and empty pass field)

        inputLogin.sendKeys( "erik.mouwes@gmail.com");
        inputPassword.sendKeys( "");

        submitButtonPrimary.click();

        sleep(5000);

        //Negative 8 (correct login field and wrong pass field)

        inputLogin.sendKeys( "erik.mouwes@gmail.com");
        inputPassword.sendKeys( "wrongPass01");

        submitButtonPrimary.click();

        sleep(5000);

//        WebElement inputLogin = webDriver.findElement(By.id("login-email"));
//        inputLogin.sendKeys( "erik.mouwes@gmail.com");
//
//        WebElement inputPassword = webDriver.findElement(By.id("login-password"));
//        inputPassword.sendKeys( "vlttar54");
//
//        WebElement submitButton = webDriver.findElement(By.xpath("//input[@class='login submit-button']"));
//        Assert.assertTrue(submitButton.isDisplayed(), "Sign In button is not displayed");
//        submitButton.click();

//        Assert.assertEquals(webDriver.getTitle(), "LinkedIn", "Homepage is not LinkedIn.com");
//        String actualHomePageTitle = webDriver.getTitle();
//        Assert.assertNotEquals(actualLoginPageTitle, actualHomePageTitle, "Page title did not change after Sign In");
//        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Homepage url is wrong.");
    }
}
