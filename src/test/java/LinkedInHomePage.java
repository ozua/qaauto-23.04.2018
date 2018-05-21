import org.openqa.selenium.WebDriver;

import java.awt.*;

public class LinkedInHomePage {
    WebDriver webDriver;

    public LinkedInHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getCurrentTitle() {
        return webDriver.getTitle();
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }
}
