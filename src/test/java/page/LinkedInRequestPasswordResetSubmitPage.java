package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class LinkedInRequestPasswordResetSubmitPage extends LinkedInBasePage {

    @FindBy(id = "resend-url")
    private WebElement resendUrlButton;

    public LinkedInRequestPasswordResetSubmitPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        waitUntilElementIsClickable(resendUrlButton, 5);
        return resendUrlButton.isDisplayed();
    }

    public LinkedInSetNewPasswordPage navigateToLinkFromEmail() {
        String messageSubject = "Erik, here's the link to reset your password";
        String messageTo = "erik.mouwes@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 30);
        String resetPasswordLink = StringUtils.substringBetween(message, "To change your LinkedIn password, click <a href=\"", "\" style").replace("&amp;","&");
        System.out.println("Content: " + resetPasswordLink);

        return new LinkedInSetNewPasswordPage(webDriver);
    }

}
