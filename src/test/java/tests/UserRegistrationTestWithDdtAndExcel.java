package tests;

import data.LoadProperties;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import data.ExcelReaderData;

import java.io.IOException;

public class UserRegistrationTestWithDdtAndExcel extends TestBase{
    private HomePage homePage;
    private UserRegistrationPage userRegistrationPage;
    private LoginPage loginPage;

    @DataProvider(name="ExcelData")
    public Object[][] userRegisterData() throws IOException
    {
        // get data from Excel Reader class
        ExcelReaderData ER = new ExcelReaderData();
        return ER.getExcelData();
    }


    @Test(priority = 1, alwaysRun = true,dataProvider="ExcelData")
    public void validRegistration(String firstname , String lastname , String email , String password) {
        homePage = new HomePage(driver);
        homePage.clickOnButtonRegister();
        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.UserRegistration(firstname,lastname,email,password,password);
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
