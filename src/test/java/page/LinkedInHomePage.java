package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInHomePage extends LinkedInBasePage {

    @FindBy(id = "nav-settings__dropdown-trigger")
    private WebElement profileNavItem;

    @FindBy(xpath = "//input[@role='combobox']")
    private WebElement searchField;

    public LinkedInHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        waitUntilElementIsVisible(profileNavItem, 120);
    }

    public boolean isPageLoaded() {
        return profileNavItem.isDisplayed();
    }

    public LinkedInSearchResultsPage search(String searchTerm) {
        waitUntilElementIsVisible(searchField, 120);
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return new LinkedInSearchResultsPage(webDriver);
    }
}
