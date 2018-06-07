package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * ResetPasswordPage object class
 */
public class LinkedInResetPasswordPage extends LinkedInBasePage {

    @FindBy(id = "username")
    private WebElement userNameField;

    @FindBy(id = "reset-password-submit-button")
    private WebElement resetPasswordSubmitButton;

    /**
     * Constructor of ResetPasswordPage
     * @param webDriver - webDriver instance
     */
    public LinkedInResetPasswordPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method for sending reset password mail to matched email box
     * @param userEmail - destination email box
     * @return - returns new RequestPasswordResetSubmitPage
     */
    public LinkedInRequestPasswordResetSubmitPage sendResetPasswordMail(String userEmail) {
        gMailService.connect();
        userNameField.sendKeys("erik.mouwes@gmail.com");
        resetPasswordSubmitButton.click();

        return new LinkedInRequestPasswordResetSubmitPage(webDriver);
    }

    /**
     * Method for checking ResetPasswordPage loading conditions
     */
    public boolean isPageLoaded() {
        return userNameField.isDisplayed();
    }
}