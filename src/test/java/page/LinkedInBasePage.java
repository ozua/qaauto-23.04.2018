package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GMailService;

public abstract class LinkedInBasePage {
    protected WebDriver webDriver;
    GMailService gMailService = new GMailService();

    public LinkedInBasePage (WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getCurrentTitle() {
        return webDriver.getTitle();
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    abstract boolean isPageLoaded();

    public WebElement waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }
}
