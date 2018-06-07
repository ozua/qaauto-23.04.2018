package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * HomePage object class
 */
public class LinkedInHomePage extends LinkedInBasePage {

    @FindBy(id = "nav-settings__dropdown-trigger")
    private WebElement profileNavItem;

    @FindBy(xpath = "//input[@role='combobox']")
    private WebElement searchField;

    /**
     * Constructor of HomePage
     * @param webDriver - webDriver instance
     */
    public LinkedInHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        waitUntilElementIsVisible(profileNavItem, 120);
    }

    /**
     * Method for searching terms on HomePage
     * @param searchTerm - term that you need to find on HomePage
     * @return - returns results of searching in to new SearchResultsPage
     */
    public LinkedInSearchResultsPage search(String searchTerm) {
        waitUntilElementIsVisible(searchField, 120);
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);

        return new LinkedInSearchResultsPage(webDriver);
    }

    /**
     * Method for checking HomePage loading conditions
     */
    public boolean isPageLoaded() {
        waitUntilElementIsVisible(profileNavItem, 120);

        return profileNavItem.isDisplayed();
    }
}
