package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * SearchResultsPage object class
 */
public class LinkedInSearchResultsPage extends LinkedInBasePage {

    @FindBy(xpath = "//h3[contains(@class,'search-results__total')]")
    private WebElement searchResultsCount;

    @FindBy(xpath = "//li[contains(@class, 'search-result search-result__occluded-item')]")
    private List<WebElement> searchResultElements;

    /**
     * Constructor of SearchResultsPage
     * @param webDriver - webDriver instance
     */
    public LinkedInSearchResultsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        waitUntilElementIsVisible(searchResultsCount, 20);
    }

    /**
     * Method for getting text from search results
     * @return - returns full list of search results
     */
    public List<String> getSearchResults() {
        List<String> searchResultsList = new ArrayList();
        for (WebElement searchResultElement : searchResultElements) {
            ((JavascriptExecutor)webDriver)
                    .executeScript("arguments[0].scrollIntoView();", searchResultElement);
            String searchResultText = searchResultElement.getText();
            searchResultsList.add(searchResultText);
        }
        System.out.println(searchResultsList);
        System.out.println(searchResultsList.size());

        return searchResultsList;
    }

    /**
     * Method for checking SearchResultsPage loading conditions
     */
    public boolean isPageLoaded() {
        return searchResultsCount.isDisplayed();
    }
}
