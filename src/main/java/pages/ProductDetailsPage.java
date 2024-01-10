package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Driver;

public class ProductDetailsPage extends PageBase{
    //By productTitleLink = By.linkText("Apple MacBook Pro 13-inch");
    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    WebElement productTitleLinkElement;
    //public By productTitle = By.xpath("//*[text()='Apple MacBook Pro 13-inch']");
    @FindBy(tagName = "h1")
    public WebElement productTitleElement;

    @FindBy(xpath = "//*[text()='Asus N551JK-XO076H Laptop']")
    public WebElement secproductTitleElement;
    //By buttonEmailAfriendly = By.cssSelector("button.button-2.email-a-friend-button");
    @FindBy(css = "button.button-2.email-a-friend-button")
    WebElement buttonEmailAfriendlyElement;

    //public By priceProduct = By.cssSelector("div.product-price");
    @FindBy(css = "div.product-price")
    public WebElement priceProductElement;
    //By addYourReview = By.linkText("Add your review");
    @FindBy(linkText = "Add your review")
    WebElement addYourReviewElement;

    // Add to WishList

    //private By addToWishlist= By.id("add-to-wishlist-button-4");
    @FindBy(id = "add-to-wishlist-button-4")
    private WebElement addToWishlistElement;

    //Msg Added to WishList
    //By msgProductAddedToWishlist = By.linkText("wishlist");
    @FindBy(linkText = "wishlist")
    WebElement msgProductAddedToWishlistElement;
    //Add to compare

    //public By addToCompar = By.cssSelector("button.button-2.add-to-compare-list-button");
    @FindBy(css = "button.button-2.add-to-compare-list-button")
    public WebElement addToComparElement;

    //Add to Cart
    @FindBy(id = "add-to-cart-button-4")
    WebElement addToCartElement;
    @FindBy(linkText = "shopping cart")
    WebElement goToCartElement;


    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        //roductTitleElement = driver.findElement(productTitle);
       // priceProductElement = driver.findElement(priceProduct);

    }
    public void clickOnProductTitle()
    {
        //productTitleLinkElement = driver.findElement(productTitleLink);
        Clicking(productTitleLinkElement);
        //productTitleElement = driver.findElement(productTitle);
    }
    public void clickOnEmailAfriendly()
    {
        //buttonEmailAfriendlyElement = driver.findElement(buttonEmailAfriendly);
        Clicking(buttonEmailAfriendlyElement);
    }
    public void clickOnAddYourReview()
    {
        //addYourReviewElement = driver.findElement(addYourReview);
        Clicking(addYourReviewElement);
    }
    public void clickOAddTonWishList()
    {
       // addToWishlistElement = driver.findElement(addToWishlist);
        Clicking(addToWishlistElement);
        //Wait
       // msgProductAddedToWishlistElement = driver.findElement(msgProductAddedToWishlist);
        Clicking(msgProductAddedToWishlistElement);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void clickOnAddToCompare()
    {
        //addToComparElement = driver.findElement(addToCompar);
        Clicking(addToComparElement);
    }
    public void clickOnAddToCart()
    {
        Clicking(addToCartElement);
        Clicking(goToCartElement);

    }






}
