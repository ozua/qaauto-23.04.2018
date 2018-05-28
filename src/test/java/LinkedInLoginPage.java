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

    public boolean isPageLoaded() {
        return submitButton.isDisplayed();
    }

    public <T> T login(String email, String password){
        inputLogin.sendKeys(email);
        inputPassword.sendKeys(password);
        submitButton.click();
        if (getCurrentUrl().contains("/feed")){
            return (T) new LinkedInHomePage(webDriver);
        }
        if (getCurrentUrl().contains("/login-submit")){
            return (T) new LinkedInFailedLoginPage(webDriver);
        }
        else {
            return (T) this;
        }
    }
}
