package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * RequestPasswordResetSubmitPage object class
 */
public class LinkedInRequestPasswordResetSubmitPage extends LinkedInBasePage {

    @FindBy(id = "resend-url")
    private WebElement resendUrlButton;

    /**
     * Constructor of RequestPasswordResetSubmitPage
     * @param webDriver - webDriver instance
     */
    public LinkedInRequestPasswordResetSubmitPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method for setting new password with help of util gMailService
     * @return - returns new SetNewPasswordPage
     */
    public LinkedInSetNewPasswordPage navigateToLinkFromEmail() {
        String messageSubject = "Erik, here's the link to reset your password";
        String messageTo = "erik.mouwes@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 120);
        String resetPasswordLink = StringUtils.substringBetween(message, "To change your LinkedIn password, click <a href=\"", "\" style").replace("&amp;","&");
        System.out.println("Content: " + resetPasswordLink);

        webDriver.get(resetPasswordLink);

        return new LinkedInSetNewPasswordPage(webDriver);
    }

    /**
     * Method for checking RequestPasswordResetSubmitPage loading conditions
     */
    public boolean isPageLoaded() {
        waitUntilElementIsClickable(resendUrlButton, 120);

        return resendUrlButton.isDisplayed();
    }
}
