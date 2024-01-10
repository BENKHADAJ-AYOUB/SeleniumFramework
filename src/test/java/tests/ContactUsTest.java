package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
    HomePage homePage;
    ContactUsPage contactUsPage;
    String email = "aazfssz1@gmail.com";
    String fullName = "Test User";
    String enquiry = "Hello Admin, this is for test";


    @Test
    public void userCanContactUs() {
        homePage = new HomePage(driver);
        homePage.clickOnButtonContactUs();
        contactUsPage = new ContactUsPage(driver);
        contactUsPage.contactUs(fullName,email,enquiry);
        Assert.assertTrue(contactUsPage.msgMailSendedElement.getText().contains("Your enquiry has been successfully sent to the store owner."));
    }


}
