package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{

    HomePage homePage;
    ProductDetailsPage productDetailsPage;
    String productName ="Apple MacBook Pro 13-inch";
    SearchPage searchPage;

    @Test(priority = 1)
    public void userCanChangeCurrency()
    {
        homePage = new HomePage(driver);
        homePage.changeCurrency();
    }


    @Test(priority = 2)
    public void userCanSearchWithAutoSugget()
    {
        searchPage = new SearchPage(driver);
        searchPage.productSearchUsingAutoSuggest("MacB");
        productDetailsPage = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsPage.productTitleElement.getText().contains(productName));
        Assert.assertTrue(productDetailsPage.priceProductElement.getText().contains("€"));
        System.out.println(productDetailsPage.priceProductElement.getText());
    }
}
