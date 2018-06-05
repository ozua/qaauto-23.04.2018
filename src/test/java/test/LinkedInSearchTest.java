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
        Assert.assertTrue(linkedInHomePage.isPageLoaded(), "Home page is not loaded");

        LinkedInSearchResultsPage linkedInSearchResultsPage = linkedInHomePage.search(searchTerm);
        Assert.assertTrue(linkedInSearchResultsPage.isPageLoaded(), "Search results page is not loaded");

        List<String> searchResultsList = linkedInSearchResultsPage.getSearchResults();
        Assert.assertEquals(searchResultsList.size(), 10, "Count of search results is wrong");

        for (String searchResult : searchResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),"Searchterm "+searchTerm+" was not found in: \n"+searchResult);
        }
    }
}
