package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PasswordChangeConfirmedPage object class
 */
public class LinkedInPasswordChangeConfirmedPage extends LinkedInBasePage {

    @FindBy(id = "reset-password-submit-button")
    private WebElement returnToHomepageButton;

    /**
     * Constructor of PasswordChangeConfirmedPage
     * @param webDriver - webDriver instance
     */
    public LinkedInPasswordChangeConfirmedPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method for click on HomeButton link on the PasswordChangeConfirmedPage
     * @return - returns new HomePage
     */
    public LinkedInHomePage clickHomeButton() {
        returnToHomepageButton.click();

        return new LinkedInHomePage(webDriver);
    }

    /**
     * Method for checking PasswordChangeConfirmedPage loading conditions
     */
    public boolean isPageLoaded() {
        waitUntilElementIsClickable(returnToHomepageButton, 120);

        return returnToHomepageButton.isDisplayed();
    }
}
