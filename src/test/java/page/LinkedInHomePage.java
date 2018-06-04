package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInHomePage extends LinkedInBasePage {

    @FindBy(id = "nav-settings__dropdown-trigger")
    private WebElement profileNavItem;

    @FindBy(xpath = "//input[@placeholder='search']")
    private WebElement searchField;

    public LinkedInHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        waitUntilElementIsClickable(profileNavItem, 120);
        return profileNavItem.isDisplayed();
    }
}
