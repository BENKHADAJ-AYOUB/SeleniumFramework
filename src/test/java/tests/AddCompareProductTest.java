package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CompareProductPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddCompareProductTest extends TestBase{
    String firstProductName="Apple MacBook Pro 13-inch";
    String secondProductName="Asus N551JK-XO076H Laptop";
    //1 search first product
    //2 search second product
    //3 add to compare
    //Clear from list

    HomePage homePage;
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    CompareProductPage compareProductPage;

    @Test(priority=1)
    public void userCanCompareProduct()
    {
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        compareProductPage = new CompareProductPage(driver);
        searchPage.productSearchUsingAutoSuggest("MacB");
        Assert.assertTrue(productDetailsPage.productTitleElement.getText().contains(firstProductName));
        productDetailsPage.clickOnAddToCompare();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        searchPage.productSearchUsingAutoSuggest("Asus");
        productDetailsPage = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsPage.secproductTitleElement.getText().contains(secondProductName));
        productDetailsPage.clickOnAddToCompare();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.navigate().to("http://demo.nopcommerce.com/compareproducts");
        Assert.assertTrue(compareProductPage.firstProductElement.getText().equals(firstProductName));
        Assert.assertTrue(compareProductPage.secondProductElement.getText().equals(secondProductName));
        compareProductPage.compareProduct();
    }
    @Test(priority = 2)
    public void userCanClearComparList()
    {
        compareProductPage.removeProductCompareTable();
    }
}
