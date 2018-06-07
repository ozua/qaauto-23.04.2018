package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * SetNewPasswordPage object class
 */
public class LinkedInSetNewPasswordPage extends LinkedInBasePage {

    @FindBy(id = "reset-password-submit-button")
    private WebElement submitButton;

    @FindBy(id = "newPassword")
    private WebElement newPasswordField;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordField;

    /**
     * Constructor of SetNewPasswordPage
     * @param webDriver - webDriver instance
     */
    public LinkedInSetNewPasswordPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method for changing password on SetNewPasswordPage
     * @param newUserPassword - data for new user password
     * @return - returns new PasswordChangeConfirmedPage
     */
    public LinkedInPasswordChangeConfirmedPage setNewUserPassword(String newUserPassword) {
        newPasswordField.sendKeys(newUserPassword);
        confirmPasswordField.sendKeys(newUserPassword);
        submitButton.click();

        return new LinkedInPasswordChangeConfirmedPage(webDriver);
    }

    /**
     * Method for checking SetNewPasswordPage loading conditions
     */
    public boolean isPageLoaded() {
        waitUntilElementIsClickable(submitButton, 120);

        return submitButton.isDisplayed();
    }
}
