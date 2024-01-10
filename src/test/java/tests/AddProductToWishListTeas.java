package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTeas extends TestBase{
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    WishListPage wishListPage;
    String productName ="Apple MacBook Pro 13-inch";
    @Test(priority = 1)
    public void userCanSearchWithAutoSugget()
    {
        searchPage = new SearchPage(driver);
        searchPage.productSearchUsingAutoSuggest("MacB");
        productDetailsPage = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsPage.productTitleElement.getText().contains(productName));
    }
    @Test(priority = 2)
    public void userCanAddEtRomveProductToWishList()
    {
        productDetailsPage.clickOAddTonWishList();
        wishListPage = new WishListPage(driver);
        Assert.assertTrue(wishListPage.nameProductWishlistElement.getText().contains(productName));
        wishListPage.clickOnXtoRemoveProductFromWishlist();
        Assert.assertTrue(wishListPage.msgIsEmptyElement.getText().contains("The wishlist is empty!"));


    }



}
