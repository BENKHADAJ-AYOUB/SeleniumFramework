package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{
    public WishListPage(WebDriver driver) {
        super(driver);


    }
    //x for remove product
    @FindBy(className = "remove-btn")
    public WebElement xRemoveProductElement ;
    //Msg WishList is Empty

   @FindBy(className = "no-data")

    public WebElement msgIsEmptyElement ;

    //Wishlist title

  @FindBy(className = "page-title")

    public WebElement wishlistElement ;
    //Name product Whishlist
    @FindBy(css = "a.product-name")
    public WebElement nameProductWishlistElement ;

    public void clickOnXtoRemoveProductFromWishlist()
    {
        Clicking(xRemoveProductElement);

    }

}
