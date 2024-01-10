package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ReviewProductTest extends TestBase{

    private HomePage homePage;
    private UserRegistrationPage userRegistrationPage;
    private LoginPage loginPage;

    String fName = "ayoub";
    String lName = "l3des";
    String email = "te1ss2dd14@gmail.com";
    String password = "123456789";

    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    String productName = "Apple MacBook Pro 13-inch";

    ReviewProductPage reviewProductPage;


    @Test(priority = 1)
    public void validRegistration() {
        homePage = new HomePage(driver);
        homePage.clickOnButtonRegister();
        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.UserRegistration(fName, lName, email, password, password);
        String exepted = userRegistrationPage.msgRegistrationCompletElement.getText();
        Assert.assertTrue(exepted.contains("Your registration completed"));
    }

    @Test(priority = 2, dependsOnMethods = "validRegistration")
    public void RegisterUserCanLogin() {
        homePage.clickOnButtonLogin();
        loginPage = new LoginPage(driver);
        loginPage.Userlogin(email, password);
        Assert.assertTrue(loginPage.myAccountElement.getText().contains("My account"));

    }

    @Test(priority = 3)
    public void userCanSearchWithAutoSugget() {
        searchPage = new SearchPage(driver);
        searchPage.productSearchUsingAutoSuggest("MacB");
        productDetailsPage = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsPage.productTitleElement.getText().contains(productName));
    }

    @Test(priority = 4)
    public void userCanReviewProduct() {
    reviewProductPage = new ReviewProductPage(driver);
    productDetailsPage.clickOnAddYourReview();
    reviewProductPage.sendReview("l3des khayb", "mabninch");
    Assert.assertTrue(reviewProductPage.msgSuccesReviewElement.getText().contains("Product review is successfully added."));
    }
    @Test(priority = 5)
    public void RegisterUserCanLogOut() {
        userRegistrationPage.logOut();

    }
}
