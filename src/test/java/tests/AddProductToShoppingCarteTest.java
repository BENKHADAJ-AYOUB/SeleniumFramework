package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CompareProductPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartePage;

public class AddProductToShoppingCarteTest extends TestBase{
    String productName ="Apple MacBook Pro 13-inch";

    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    ShoppingCartePage shoppingCartePage;

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
    public void userCanChangeQteEtRemove()
    {
        shoppingCartePage.changeQte("3");
        shoppingCartePage.removeProductOnCart();
        Assert.assertTrue(shoppingCartePage.cartEmptytElement.getText().contains("Your Shopping Cart is empty!"));
    }
}
