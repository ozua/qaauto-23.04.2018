package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * FailedLoginPage object class
 */
public class LinkedInFailedLoginPage extends LinkedInBasePage {

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement errorMessage;

    @FindBy(id = "session_key-login")
    private WebElement emailField;

    /**
     * Constructor of FailedLoginPage
     * @param webDriver - webDriver instance
     */
    public LinkedInFailedLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method for getting text from error message on the FailedLoginPage
     * @return - returns text from error message
     */
    public  String getErrorMessageText() {


        return errorMessage.getText();
    }

    /**
     * Method for checking FailedLoginPage loading conditions
     */
    public boolean isPageLoaded() {
        return emailField.isDisplayed();
    }
}
