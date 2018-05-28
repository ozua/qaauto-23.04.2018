import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInReturnedLoginPage extends LinkedInBasePage {

    @FindBy(xpath = "//input[@class='login submit-button']")
    private WebElement submitButton;

    public LinkedInReturnedLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isSignInButtonDisplayed(){
        return submitButton.isDisplayed();
    }

}
