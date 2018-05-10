import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {

    @Test
    public void successfulLoginTest() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");

        String actualLoginPageTitle = webDriver.getTitle();

//        Assert.assertEquals("a", "b", "Probably 'a' is not equal to 'b'");
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page is wrong");

        WebElement inputLogin = webDriver.findElement(By.id("login-email"));
        inputLogin.sendKeys( "erik.mouwes@gmail.com");

        WebElement inputPassword = webDriver.findElement(By.id("login-password"));
        inputPassword.sendKeys( "vlttar54");

        WebElement submitButton = webDriver.findElement(By.xpath("//input[@class='login submit-button']"));
        Assert.assertTrue(submitButton.isDisplayed(), "Sign In button is not displayed");
        submitButton.click();

        Assert.assertEquals(webDriver.getTitle(), "LinkedIn", "Homepage is not LinkedIn.com");
        String actualHomePageTitle = webDriver.getTitle();
        Assert.assertNotEquals(actualLoginPageTitle, actualHomePageTitle, "Page title did not change after Sign In");
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Homepage url is wrong.");
    }
}
