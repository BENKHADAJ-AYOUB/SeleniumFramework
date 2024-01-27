package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithFakerTest extends TestBase {
    private HomePage homePage;
    private UserRegistrationPage userRegistrationPage;
    private LoginPage loginPage;
    Faker fakeData = new Faker();
    String firstName = fakeData.name().firstName();
    String lastName = fakeData.name().lastName();
    String mail = fakeData.internet().emailAddress();
    String password= fakeData.number().digits(9).toString();

    @Test(priority = 1, alwaysRun = true)
    public void validRegistration() {
        homePage = new HomePage(driver);
        homePage.clickOnButtonRegister();
        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.UserRegistration(firstName, lastName, mail, password, password);
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
        loginPage.Userlogin(mail, password);
        Assert.assertTrue(loginPage.myAccountElement.getText().contains("My account"));

    }

}
