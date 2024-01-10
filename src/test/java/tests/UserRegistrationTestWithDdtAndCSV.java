package tests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.FileReader;
import java.io.IOException;

public class UserRegistrationTestWithDdtAndCSV extends TestBase {
    private HomePage homePage;
    private UserRegistrationPage userRegistrationPage;
    private LoginPage loginPage;

    CSVReader reader;//qui va lire la data du fichier csv

    @Test(priority = 1, alwaysRun = true)
    public void validRegistration() throws  CsvValidationException, IOException {
        // get path of CSV file
        String CSV_file = System.getProperty("user.dir") + "/src/test/java/data/UserData.csv";
        reader = new CSVReader(new FileReader(CSV_file));

        String[] csvCell;

        // while loop will be executed till the lastvalue in CSV file .
        while ((csvCell = reader.readNext()) != null) {

            String firstname = csvCell[0];
            String lastName = csvCell[1];
            String email = csvCell[2];
            String password = csvCell[3];

            homePage = new HomePage(driver);
            homePage.clickOnButtonRegister();
            userRegistrationPage = new UserRegistrationPage(driver);
            userRegistrationPage.UserRegistration(firstname,lastName,email, password, password);
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

}
