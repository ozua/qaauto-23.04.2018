package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * LoginPage object class
 */
public class LinkedInLoginPage extends LinkedInBasePage {

    @FindBy(id = "login-email")
    private WebElement inputLogin;

    @FindBy(id = "login-password")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@class='login submit-button']")
    private WebElement submitButton;

    @FindBy(xpath = "//a[@class='link-forgot-password']")
    private WebElement resetPasswordLink;

    /**
     * Constructor of LoginPage
     * @param webDriver - webDriver instance
     */
    public LinkedInLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method for log in to account with determined data providers for each page type in the scope
     * @param email - email data
     * @param password - password data
     * @param <T> - general Text parameter
     * @return - returns one of the Pages. Depends from used DataProvider
     */
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

    /**
     * Method for click on ForgotPassword link on the LoginPage
     * @return - returns new ResetPasswordPage
     */
    public LinkedInResetPasswordPage clickOnForgotPasswordLink() {
        resetPasswordLink.click();

        return new LinkedInResetPasswordPage(webDriver);
    }

    /**
     * Method for checking LoginPage loading conditions
     */
    public boolean isPageLoaded() {
        return submitButton.isDisplayed();
    }
}
