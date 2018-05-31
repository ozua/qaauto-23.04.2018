package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.LinkedInBasePage;

public class LinkedInRequestPasswordResetSubmitPage extends LinkedInBasePage {

    @FindBy(id = "resend-url")
    private WebElement resendUrlButton;

    public LinkedInRequestPasswordResetSubmitPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return resendUrlButton.isDisplayed();
    }

}
