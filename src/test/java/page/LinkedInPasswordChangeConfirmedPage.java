package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInPasswordChangeConfirmedPage extends LinkedInBasePage {

    @FindBy(id = "reset-password-submit-button")
    private WebElement returnToHomepageButton;

    public LinkedInPasswordChangeConfirmedPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        waitUntilElementIsClickable(returnToHomepageButton, 5);
        return returnToHomepageButton.isDisplayed();
    }

    public LinkedInHomePage clickHomeButton() {
        return new LinkedInHomePage(webDriver);
    }
}
