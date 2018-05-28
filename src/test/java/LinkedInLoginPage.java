import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInLoginPage extends LinkedInBasePage {

    @FindBy(id = "login-email")
    private WebElement inputLogin;

    @FindBy(id = "login-password")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@class='login submit-button']")
    private WebElement submitButton;

    public LinkedInLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public LinkedInHomePage login(String email, String password){
        inputLogin.sendKeys(email);
        inputPassword.sendKeys(password);
        submitButton.click();
        return PageFactory.initElements(webDriver, LinkedInHomePage.class);
    }

    public LinkedInFailedLoginPage unsuccesfullLogin(String email, String password){
        inputLogin.sendKeys(email);
        inputPassword.sendKeys(password);
        submitButton.click();
        return PageFactory.initElements(webDriver, LinkedInFailedLoginPage.class);
    }

    public LinkedInReturnedLoginPage emptyLogin(String email, String password){
        inputLogin.sendKeys(email);
        inputPassword.sendKeys(password);
        submitButton.click();
        return PageFactory.initElements(webDriver, LinkedInReturnedLoginPage.class);
    }

    public boolean isSignInButtonDisplayed(){
        return submitButton.isDisplayed();
    }
}
