package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInSetNewPasswordPage extends LinkedInBasePage {

    @FindBy(id = "reset-password-submit-button")
    private WebElement submitButton;

    public LinkedInSetNewPasswordPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        waitUntilElementIsClickable(submitButton, 5);
        return submitButton.isDisplayed();
    }

    public LinkedInPasswordChangeConfirmedPage setNewUserPassword(String newUserPassword) {
        return new LinkedInPasswordChangeConfirmedPage(webDriver);
    }
}
