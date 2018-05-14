import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedInLoginPage {
    private WebDriver webDriver;

    private WebElement inputLogin = webDriver.findElement(By.id("login-email"));
    private WebElement inputPassword = webDriver.findElement(By.id("login-password"));
    private WebElement submitButton = webDriver.findElement(By.xpath("//input[@class='login submit-button']"));

    public void login(String email, String password){
        inputLogin.sendKeys( "email");
        inputPassword.sendKeys( "password");
        submitButton.click();
    }
}
