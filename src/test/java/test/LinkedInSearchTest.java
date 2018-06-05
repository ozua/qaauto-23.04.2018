package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedInHomePage;
import page.LinkedInSearchResultsPage;

import java.util.List;

public class LinkedInSearchTest extends LinkedInBaseTest {

    @Test
    public void basicSearchTest() {
        String searchTerm = "HR";

        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login("erik.mouwes@gmail.com", "vlttar54");
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

        LinkedInSearchResultsPage linkedInSearchResultsPage = linkedInHomePage.search(searchTerm);
        Assert.assertTrue(linkedInSearchResultsPage.isPageLoaded(), "Search results page is not loaded");

        List<String> searchResultList = linkedInSearchResultsPage.getSearchResultsCount()
        Assert.assertEquals(searchResultList.size(), 10, "Count of search results is wrong");

        for (String searchResult:searchResultList){
            Assert.assertTrue(searchResult.contains(searchTerm), "Search results page is not loaded");
        }
    }
}
