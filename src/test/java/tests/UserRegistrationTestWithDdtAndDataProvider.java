package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDdtAndDataProvider extends TestBase{
    private HomePage homePage;
    private UserRegistrationPage userRegistrationPage;
    private LoginPage loginPage;
    //Méthode dataProvider
    @DataProvider(name = "testData")
    public static Object[][]userData()
    {
        return new Object[][]{
                {"ayoub", "xdjr", "tesdtddkk154a@gmail.com", "123456789", "123456789"},//ok
                {"ayodub", "xdr", "tesdtfdk154a@gmail.com", "123456789", "123456789"},//ok
                {"ayosub", "xdr", "tesdtdkd154a@gmail.com", "123456789", "123456789"},//ko username
                {"ayozub", "xdr", "tesdtdkv154a@gmail.com", "123456789", "123456789"}//ko password
        };


    }

    @Test(priority = 1, alwaysRun = true,dataProvider = "testData")
    public void validRegistration(String firstname , String lastname, String email, String password,String rePassword) {
        homePage = new HomePage(driver);
        homePage.clickOnButtonRegister();
        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.UserRegistration(firstname,lastname,email,password,rePassword);
        String exepted = userRegistrationPage.msgRegistrationCompletElement.getText();
        String actual = "Your registration completed";
        Assert.assertTrue(actual.contains(exepted));
        //connexion
        homePage.clickOnButtonLogin();
        loginPage = new LoginPage(driver);
        loginPage.Userlogin(email, password);
        Assert.assertTrue(loginPage.myAccountElement.getText().contains("My account"));
        userRegistrationPage.logOut();
    }

}
