package tests;

import data.LoadProperties;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDdtAndProperitieFile extends TestBase{
    private HomePage homePage;
    private UserRegistrationPage userRegistrationPage;
    private LoginPage loginPage;

    String firstname = LoadProperties.userData.getProperty("firstname");
    String lastname = LoadProperties.userData.getProperty("lastname");
    String email = LoadProperties.userData.getProperty("email");
    String Password = LoadProperties.userData.getProperty("password");

    @Test(priority = 1, alwaysRun = true)
    public void validRegistration() {
        homePage = new HomePage(driver);
        homePage.clickOnButtonRegister();
        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.UserRegistration(firstname,lastname,email,Password,Password);
        String exepted = userRegistrationPage.msgRegistrationCompletElement.getText();
        String actual = "Your registration completed";
        Assert.assertTrue(actual.contains(exepted));
        //connexion
        homePage.clickOnButtonLogin();
        loginPage = new LoginPage(driver);
        loginPage.Userlogin(email, Password);
        Assert.assertTrue(loginPage.myAccountElement.getText().contains("My account"));
        userRegistrationPage.logOut();
    }

}
