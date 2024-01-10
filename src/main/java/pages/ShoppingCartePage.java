package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartePage extends PageBase{
    public ShoppingCartePage(WebDriver driver) {
        super(driver);
    }
    //name of product
    @FindBy(css = "a.product-name")
    public WebElement nameProductElement;
    //Qte
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr/td[5]/input")
    WebElement qteProductElement;
    @FindBy(className = "product-subtotal")
    WebElement totalProductElement;

    @FindBy(className = "product-unit-price")
    WebElement priceProductElement;

    //remove
    @FindBy(css = "button.remove-btn")
    WebElement removeProductElement;

    //updatecart
    @FindBy(id = "updatecart")
    WebElement updatecartElement;
    //Your Shopping Cart is empty!cartEmptytElement
    @FindBy(className = "no-data")
    public WebElement cartEmptytElement;
    //button checkout
    @FindBy(id = "checkout")
    WebElement checkoutElement;
    //agree conditon
    @FindBy(id = "termsofservice")
    WebElement agreeElement;

    public void removeProductOnCart()
    {
        Clicking(removeProductElement);
    }
    public void changeQte(String qte)
    {
        clearInput(qteProductElement);
        sendText(qteProductElement,qte);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Clicking(updatecartElement);
    }
    public void clickOnCheckout()
    {
        Clicking(agreeElement);
        Clicking(checkoutElement);
    }



}
