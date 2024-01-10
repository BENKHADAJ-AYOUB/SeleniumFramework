package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    //Country
    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement countryElement;
    //State
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/form/div/div/div[2]/div/div/div[6]/select")
    WebElement stateElement;
    //City
    @FindBy(id = "BillingNewAddress_City")
    WebElement cityElement;
    //Adresse
    @FindBy(id = "BillingNewAddress_Address1")
    WebElement adresseElement;
    //zip
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement zipCodeElement;
    //Phone Number
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneElement;
    //button continueAdresse
    @FindBy(css = "button.button-1.new-address-next-step-button")
    WebElement btnContinueAdresseElement;

    //for register
    @FindBy(css = "button.button-1.register-button")
    WebElement btnRegisterElement;
    //assert register
    @FindBy(tagName = "h1")
    public WebElement titlePageAsserElement;
    @FindBy(css = "button.button-1.shipping-method-next-step-button")
    WebElement btnContinueShippingMethodeElement;
    @FindBy(css = "button.button-1.payment-method-next-step-button")
    WebElement btnContinuePaimentMethodeElement;

    @FindBy(css = "button.button-1.payment-info-next-step-button")
    WebElement btnContinuePaimentMethode2Element;
    //btn confirmatin
    @FindBy(css = "button.button-1.confirm-order-next-step-button")
    WebElement btnConfirmationElement;

    //Link Click here for order details.
    @FindBy(linkText = "Click here for order details.")
    public WebElement linkAfterChekoutElement;



    public void userCheckoutProduct(String country, String state, String city, String adresse, String zip, String phone) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        select = new Select(countryElement);
        select.selectByVisibleText(country);
        select = new Select(stateElement);
        select.selectByVisibleText(state);
        sendText(cityElement, city);
        sendText(adresseElement, adresse);
        sendText(zipCodeElement, zip);
        sendText(phoneElement, phone);
        Clicking(btnContinueAdresseElement);
        Clicking(btnContinueShippingMethodeElement);
        Clicking(btnContinuePaimentMethodeElement);
        Clicking(btnContinuePaimentMethode2Element);
    }

    public void confirmeOrder()
    {
        Clicking(btnConfirmationElement);
    }
    public void goToprintOrder()
    {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Clicking(linkAfterChekoutElement);
    }



    public void clickOnRegister() {
        Clicking(btnRegisterElement);
    }


}
