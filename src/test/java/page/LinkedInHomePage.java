package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInHomePage extends LinkedInBasePage {

    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavItem;

    public LinkedInHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return profileNavItem.isDisplayed();
    }
}
