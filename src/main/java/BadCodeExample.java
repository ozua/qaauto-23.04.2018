import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static java.lang.Thread.sleep;

public class BadCodeExample {
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Hello world!");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.google.com/");

        WebElement searchField = webDriver.findElement(By.id("lst-ib"));
        searchField.sendKeys( "selenium");

        sleep (1000);

        WebElement searchButton = webDriver.findElement(By.xpath("//input[@type='button' and contains(@value, 'Google')]"));
        sleep (1000);
        //searchButton.click();

        searchField.sendKeys(Keys.ENTER);
        sleep (1000);

        List<WebElement> searchResults = webDriver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));

        System.out.println(searchResults.size());

        for (WebElement searchResult : searchResults) {
            String searchResultText = searchResult.getText();
            if (searchResultText.contains("Selenium")) {
                System.out.println("SearchTerm Found!!");
            }
            System.out.println(searchResultText);
        }

//        for (int i = 1; i <= 10; i++) {
//            WebElement searchResult = webDriver.findElement(By.xpath("//div[@class='srg']/div["+ i +"]"));
//            String searchResultText = searchResult.getText();
//            System.out.println(searchResult.getText());
//            if (searchResultText.contains("Selenium")) {
//                System.out.println("SearchTerm Found!!");
//            }
//            System.out.println(searchResultText);
//        }

        sleep (5000);
        webDriver.close();

    }
}
