package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedInHomePage;
import page.LinkedInSearchResults;

import java.util.List;

public class LinkedInSearchTest extends LinkedInBaseTest {

    @Test
    public void basicSearchTest() {
        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login("erik.mouwes@gmail.com", "vlttar54");
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

        LinkedInSearchResults linkedInSearchResults = linkedInHomePage.search(searchTerm);
        Assert.assertTrue(linkedInSearchResults.isPageLoaded(), "Search results page is not loaded");

        List<String> searchResultList = linkedInSearchResults.getSearchResults();
        Assert.assertEquals(searchResultList.size(), 10, "Count of search results is wrong");

        for (String searchResult:searchResultList){
            Assert.assertTrue(searchResult.contains(searchTerm), "Search results page is not loaded");
        }
    }
}
