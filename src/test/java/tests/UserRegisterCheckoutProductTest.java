package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class UserRegisterCheckoutProductTest extends TestBase{
    String productName ="Apple MacBook Pro 13-inch";

    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    ShoppingCartePage shoppingCartePage;
    CheckoutPage checkoutPage;
    String fName = "ayoub";
    String lName = "l3des";
    String email = "c1@gmail.com";
    String oldPassword = "123456789";
    String newPassword = "1234567890";
    UserRegistrationPage userRegistrationPage;
    LoginPage loginPage;
    HomePage homePage;
    OrderDetailsPage orderDetailsPage;

    @Test(priority=1)
    public void userCanSearchProduct()
    {
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        searchPage.productSearchUsingAutoSuggest("MacB");
        Assert.assertTrue(productDetailsPage.productTitleElement.getText().contains(productName));

    }
    @Test(priority = 2)
    public void userCanAddProductToCart()
    {
        productDetailsPage.clickOnAddToCart();
        shoppingCartePage = new ShoppingCartePage(driver);
        Assert.assertTrue(shoppingCartePage.nameProductElement.getText().contains(productName));
    }
    @Test(priority = 3)
    public void userCanRegisterAfterChoisProductToCheckout()
    {
        shoppingCartePage.clickOnCheckout();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickOnRegister();
        Assert.assertTrue(checkoutPage.titlePageAsserElement.getText().contains("Register"));
    }



    @Test(priority = 4)
    public void validRegistration() {
        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.UserRegistration(fName, lName, email, oldPassword, oldPassword);
        String exepted = userRegistrationPage.msgRegistrationCompletElement.getText();
        Assert.assertTrue(exepted.contains("Your registration completed"));
    }

    @Test(priority = 5,dependsOnMethods = "validRegistration")

    public void RegisterUserCanLogin() {
        homePage = new HomePage(driver);
        homePage.clickOnButtonLogin();
        loginPage = new LoginPage(driver);
        loginPage.Userlogin(email, oldPassword);
        //Assert.assertTrue(loginPage.myAccountElement.getText().contains("My account"));

    }
    @Test(priority = 6)
    public void userCancheckout()
    {
        shoppingCartePage.clickOnCheckout();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        checkoutPage.userCheckoutProduct("Morocco","Other","agadir","rue 45","8000","0783353625");
        checkoutPage.confirmeOrder();
        Assert.assertTrue(checkoutPage.linkAfterChekoutElement.getText().contains("Click here for order details."));
    }

    @Test(priority = 7)
    public void userCanPrintOrder() throws InterruptedException {

        checkoutPage.goToprintOrder();
        orderDetailsPage = new OrderDetailsPage(driver);
        orderDetailsPage.printOrder();
        orderDetailsPage.pdfInvoiceOrder();
        Thread.sleep(5000);
    }


}
