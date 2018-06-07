package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GMailService;

/**
 * General class of LinkedIn project
 */
public abstract class LinkedInBasePage {
    protected WebDriver webDriver;
    protected static GMailService gMailService = new GMailService();

    /**
     * Constructor of BasePage
     * @param webDriver - webDriver instance
     */
    public LinkedInBasePage (WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Method for getting current page title
     * @return - returns a title value
     */
    public String getCurrentTitle() {
        return webDriver.getTitle();
    }

    /**
     * Method for getting current page URL
     * @return - returns a URL value
     */
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    /**
     * Method for checking page loading conditions
     */
    abstract boolean isPageLoaded();

    /**
     * Method for stopping test until all matched elements will be available to click on page
     * @param webElement - webElement instance
     * @param timeOutInSeconds - wait time until all matched conditions will be passed
     * @return - returns waited webElement
     */
    public WebElement waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));

        return webElement;
    }

    /**
     * Method for stopping test until all matched elements will be visible on page
     * @param webElement - webElement instance
     * @param timeOutInSeconds - wait time until all matched conditions will be passed
     * @return - returns waited webElement
     */
    public WebElement waitUntilElementIsVisible (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));

        return webElement;
    }
}
