import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class LinkedInBasePage {
    protected WebDriver webDriver;

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
    }
}
