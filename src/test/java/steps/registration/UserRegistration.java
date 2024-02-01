package steps.registration;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.CucumberOptions;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase {
    HomePage homePage;
    UserRegistrationPage userRegistrationPage;
    LoginPage loginPage;
    Faker fakeData = new Faker();
    String firstName = fakeData.name().firstName();
    String lastName = fakeData.name().lastName();
    String mail = fakeData.internet().emailAddress();
    String password= fakeData.number().digits(9).toString();
    @Given("the user in the home page")
    public void the_user_in_the_home_page() {
        homePage = new HomePage(driver);
        homePage.clickOnButtonRegister();

    }
    @When("I click on register link")
    public void i_click_on_register_link() {
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
    }
    /* @When("I entered the bdd")
     public void i_entered_the_bdd() {
         userRegistrationPage = new UserRegistrationPage(driver);
         userRegistrationPage.UserRegistration("tchach","lflash","tchach@gmail.com","123456789","123456789");
     }*/
    @When("I entered for register")
    public void i_entered_for_register() {
        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.UserRegistration(firstName,lastName,mail,password,password);
    }
    @When("I entered for login")
    public void i_entered_for_login() {
        homePage.clickOnButtonLogin();
        loginPage = new LoginPage(driver);
        loginPage.Userlogin(mail,password);
    }
    @Then("The registration page displayed successfully")
    public void the_registration_page_displayed_successfully() {
        Assert.assertTrue(userRegistrationPage.logOutElement.getText().contains("Log out"));
        userRegistrationPage.logOut();

    }
}
