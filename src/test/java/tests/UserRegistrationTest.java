package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import org.testng.Assert;

public class UserRegistrationTest extends TestBase {
    private HomePage homePage;
    private UserRegistrationPage userRegistrationPage;
    private LoginPage loginPage;

    @Test(priority = 1, alwaysRun = true)
    public void validRegistration() {
        homePage = new HomePage(driver);
        homePage.clickOnButtonRegister();
        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.UserRegistration("ayoub", "xdr", "tesdtdk154a@gmail.com", "123456789", "123456789");
        String exepted = userRegistrationPage.msgRegistrationCompletElement.getText();
        String actual = "Your registration completed";
        Assert.assertTrue(actual.contains(exepted));
    }

    @Test(dependsOnMethods = "RegisterUserCanLogin")
    public void RegisterUserCanLogOut() {
        userRegistrationPage.logOut();
    }

    @Test(dependsOnMethods = "validRegistration")
    public void RegisterUserCanLogin() {
        homePage.clickOnButtonLogin();
        loginPage = new LoginPage(driver);
        loginPage.Userlogin("tesdtdk154a@gmail.com", "123456789");
        Assert.assertTrue(loginPage.myAccountElement.getText().contains("My account"));

    }

}
