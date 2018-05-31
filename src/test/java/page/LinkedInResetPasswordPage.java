package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInResetPasswordPage extends LinkedInBasePage {

    @FindBy(id = "username")
    private WebElement userNameField;

    @FindBy(id = "reset-password-submit-button")
    private WebElement resetPasswordSubmitButton;

    public LinkedInResetPasswordPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public LinkedInRequestPasswordResetSubmitPage sendResetPasswordMail() {
        userNameField.sendKeys("erik.mouwes@gmail.com");
        resetPasswordSubmitButton.click();
        return new LinkedInRequestPasswordResetSubmitPage(webDriver);
    }

    public boolean isPageLoaded() {
        return userNameField.isDisplayed();
    }
}