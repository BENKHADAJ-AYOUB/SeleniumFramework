package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearcheTest extends TestBase{
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    String productName ="Apple MacBook Pro 13-inch";
    @Test
    public void userCanSearchProduct()
    {
        searchPage = new SearchPage(driver);
        searchPage.productSerch(productName);
        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.clickOnProductTitle();
        Assert.assertTrue(productDetailsPage.productTitleElement.getText().contains(productName));

    }
}
