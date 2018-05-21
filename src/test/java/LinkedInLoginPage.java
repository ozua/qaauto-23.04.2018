import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedInLoginPage extends LinkedInBasePage {
    private WebElement inputLogin;
    private WebElement inputPassword;
    private WebElement submitButton;

    public LinkedInLoginPage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    public void initElements(){
        inputLogin = webDriver.findElement(By.id("login-email"));
        inputPassword = webDriver.findElement(By.id("login-password"));
        submitButton = webDriver.findElement(By.xpath("//input[@class='login submit-button']"));
    }

    public void login(String email, String password){
        inputLogin.sendKeys( email);
        inputPassword.sendKeys( password);
        submitButton.click();
    }

    public boolean isSignInButtonDisplayed(){
        return submitButton.isDisplayed();
    }
}
