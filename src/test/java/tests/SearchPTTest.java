package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

public class SearchPTTest extends TestBase2{
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    String productName ="Apple MacBook Pro 13-inch";
    @Test
    public void userCanSearchProduct()
    {
        searchPage = new SearchPage(getDriver());
        searchPage.productSerch(productName);
        productDetailsPage = new ProductDetailsPage(getDriver());
        productDetailsPage.clickOnProductTitle();
        Assert.assertTrue(productDetailsPage.productTitleElement.getText().contains(productName));

    }

}
