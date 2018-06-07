package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;

/**
 * LoginTest object class
 */
public class LinkedinLoginTest extends LinkedInBaseTest {

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "erik.mouwes@gmail.com", "vlttar54" },
                { "ERIK.MOUWES@GMAIL.COM", "vlttar54" }
        };
    }

    @DataProvider
    public Object[][] emptyFieldsDataProvider() {
        return new Object[][]{
                { "", "" },
                { "", "vlttar54" },
                { "", "4" },
                { "erik.mouwes@gmail.com", "" }
        };
    }

    @DataProvider
    public Object[][] invalidDataProvider() {
        return new Object[][]{
                { "invalid@gil.com", "vlttar54" },
                { "invalid@gil.com", "invalidpass" },
                { "invalid@gil.com", "4" },
                { "erik.mouwes@gmail.com", "invalidpass" },
                { "erik.mouwes@gmail.com", "4" }
        };
    }

    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String email, String password){
        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login(email, password);

        Assert.assertEquals(linkedInHomePage.getCurrentUrl(), "https://www.linkedin.com/feed/", "Homepage url is wrong.");
    }

    @Test(dataProvider = "invalidDataProvider")
    public void negativeReturnedToLoginSubmitTest(String email, String password){
        LinkedInFailedLoginPage linkedInFailedLoginPage = linkedInLoginPage.login(email, password);

        Assert.assertEquals(linkedInFailedLoginPage.getErrorMessageText(), "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.", "Wrong error message text displayed");
    }

    @Test(dataProvider = "emptyFieldsDataProvider")
    public void negativeLoginTestWithEmptyLoginAndPasswordFields(String email, String password){
        linkedInLoginPage.login(email, password);

        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");
    }

}
