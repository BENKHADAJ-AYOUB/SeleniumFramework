package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {

        super(driver);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    //By registerButton = By.className("ico-register");
    @FindBy(className = "ico-register")
    WebElement registerButtonElement;
    //By contactUsLink = By.linkText("Contact us");
    @FindBy(linkText = "Contact us")
    WebElement contactUsLinkElement ;

    //Currency
    //By currencyDropL = By.id("customerCurrency");
    @FindBy(id = "customerCurrency")
    WebElement currencyDropLElement ;

    //Hover




    public void clickOnButtonRegister() {

        Clicking(registerButtonElement);

    }

    //By loginButton = By.linkText("Log in");
    @FindBy(linkText = "Log in")
    public WebElement loginButtonElement;


    public void clickOnButtonLogin() {

        Clicking(loginButtonElement);

    }

    public void clickOnButtonContactUs() {
        scrollToBottom();
        Clicking(contactUsLinkElement);

    }
    public void changeCurrency()
    {
        select = new Select(currencyDropLElement);
        select.selectByVisibleText("Euro");
    }


    //By computers = By.linkText("Computers");
    @FindBy(linkText = "Computers")
    WebElement computersElement;
    //By notebooks = By.linkText("Notebooks");
    @FindBy(linkText = "Notebooks")
    WebElement notebooksElement;
    public void selectNotebooksMenu()
    {
        actions.moveToElement(computersElement).perform();
        actions.moveToElement(notebooksElement).click().perform();
    }

}
