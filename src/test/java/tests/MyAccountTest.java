package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

import java.time.Duration;

public class MyAccountTest extends TestBase{

    private HomePage homePage;
    private UserRegistrationPage userRegistrationPage;
    private MyAccountPage myAccountPage;
    private LoginPage loginPage;


    String fName = "ayoub";
    String lName = "l3des";
    String email = "t1ss5dds1z@gmail.com";
    String oldPassword = "123456789";
    String newPassword = "1234567890";


    @Test(priority = 1)
    public void validRegistration() {
        homePage = new HomePage(driver);
        homePage.clickOnButtonRegister();
        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.UserRegistration(fName, lName, email, oldPassword, oldPassword);
        String exepted = userRegistrationPage.msgRegistrationCompletElement.getText();
        Assert.assertTrue(exepted.contains("Your registration completed"));
    }
    @Test(priority = 2,dependsOnMethods = "validRegistration")
    public void RegisterUserCanLogin() {
        homePage.clickOnButtonLogin();
        loginPage = new LoginPage(driver);
        loginPage.Userlogin(email, oldPassword);
        Assert.assertTrue(loginPage.myAccountElement.getText().contains("My account"));

    }

    @Test (priority = 3,dependsOnMethods ="RegisterUserCanLogin" )
    public void RegisterUserCanChangePassowrd()
    {
        myAccountPage = new MyAccountPage(driver);
        loginPage.clickOnMyAccount();
        myAccountPage.openChangePasssword();
        myAccountPage.changePassord(oldPassword,newPassword);
        Assert.assertTrue(myAccountPage.msgPasswordChangedElement.getText().contains("Password was changed"));
        myAccountPage.closeMsgchangedPassword();

    }
    @Test(priority = 4)
    public void RegisterUserCanLogOut() {
        userRegistrationPage.logOut();

    }




}
