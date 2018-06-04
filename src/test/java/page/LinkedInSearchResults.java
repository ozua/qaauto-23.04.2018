package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInSearchResults extends LinkedInBasePage {

    @FindBy(xpath = "//h3[contains(@class, 'search-results_total')]")

    public LinkedInSearchResults(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return false;
    }
}
