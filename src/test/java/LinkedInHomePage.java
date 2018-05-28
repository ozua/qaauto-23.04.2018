import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LinkedInHomePage extends LinkedInBasePage {

    public LinkedInHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
}
