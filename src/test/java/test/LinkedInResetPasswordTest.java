package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

public class LinkedInResetPasswordTest extends LinkedInBaseTest {

    @Test
    public void successfullPasswordResetTest() {
        String userEmail = "erik.mouwes@gmail.com";
        String newUserPassword = "vlttar54";

        LinkedInResetPasswordPage linkedInResetPasswordPage = linkedInLoginPage.clickOnForgotPasswordLink();
        Assert.assertTrue(linkedInResetPasswordPage.isPageLoaded(), "Forgot password page is not loaded");

        LinkedInRequestPasswordResetSubmitPage linkedInRequestPasswordResetSubmitPage = linkedInResetPasswordPage.sendResetPasswordMail(userEmail);
        Assert.assertTrue(linkedInRequestPasswordResetSubmitPage.isPageLoaded(), "Resend Url reset password page is not loaded");

        LinkedInSetNewPasswordPage linkedInSetNewPasswordPage = linkedInRequestPasswordResetSubmitPage.navigateToLinkFromEmail();
        Assert.assertTrue(linkedInSetNewPasswordPage.isPageLoaded(), "Set new password page is not loaded");

        LinkedInPasswordChangeConfirmedPage linkedinPasswordChangeConfirmedPage = linkedInSetNewPasswordPage.setNewUserPassword(newUserPassword);
        Assert.assertTrue(linkedinPasswordChangeConfirmedPage.isPageLoaded(),"Password change confirmed page is not loaded.");

        LinkedInHomePage linkedinHomePage = linkedinPasswordChangeConfirmedPage.clickHomeButton();
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),"Home page is not loaded.");
    }
}
