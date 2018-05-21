import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedInLoginPage {
    public static boolean isErrorMessageDisplayed;
    private WebDriver webDriver;

    private WebElement inputLogin;
    private WebElement inputPassword;
    private WebElement submitButton;
    private WebElement errorMessage;

    public LinkedInLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
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

    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }

    public  String getCurrentTitle(){
        return webDriver.getTitle();
    }

    public  String errorMessage(){
        errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));
        return errorMessage.getText();
    }

    public boolean isErrorMessageDisplayed(){
        errorMessage();
        return errorMessage.isDisplayed();

    }

}
