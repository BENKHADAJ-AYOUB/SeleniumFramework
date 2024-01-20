package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyPTTestSG extends TestBase2SeleniumGrid{

    HomePage homePage;
    ProductDetailsPage productDetailsPage;
    String productName ="Apple MacBook Pro 13-inch";
    SearchPage searchPage;

    @Test(priority = 1)
    public void userCanChangeCurrency()
    {
        homePage = new HomePage(getDriver());
        homePage.changeCurrency();
    }


    @Test(priority = 2)
    public void userCanSearchWithAutoSugget()
    {
        searchPage = new SearchPage(getDriver());
        searchPage.productSearchUsingAutoSuggest("MacB");
        productDetailsPage = new ProductDetailsPage(getDriver());
        Assert.assertTrue(productDetailsPage.productTitleElement.getText().contains(productName));
        Assert.assertTrue(productDetailsPage.priceProductElement.getText().contains("€"));
        System.out.println(productDetailsPage.priceProductElement.getText());
    }
}
