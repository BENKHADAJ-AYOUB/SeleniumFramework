package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggetTest extends TestBase{
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    String productName ="Apple MacBook Pro 13-inch";
    @Test
    public void userCanSearchWithAutoSugget()
    {
        searchPage = new SearchPage(driver);
        searchPage.productSearchUsingAutoSuggest("MacB");
        productDetailsPage = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsPage.productTitleElement.getText().contains(productName));
    }
}
