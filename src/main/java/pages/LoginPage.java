package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class LoginPage extends PageBase
{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //private By mailLogin = By.xpath("//input[@class='email']");
    @FindBy(xpath = "//input[@class='email']")
    private WebElement mailLoginElement;
    //private By passwordLogin = By.xpath("//input[@class='password']");
    @FindBy(xpath = "//input[@class='password']")
    private WebElement passwordLoginElement;

    //private By buttonLogin = By.cssSelector("button.button-1.login-button");
    @FindBy(css = "button.button-1.login-button")
    private WebElement buttonLoginElement ;

    //public By myAccount = By.cssSelector("a.ico-account");
    @FindBy(css = "a.ico-account")
    public WebElement myAccountElement;

    public void Userlogin(String mail,String password)
    {

        sendText(mailLoginElement,mail);
        sendText(passwordLoginElement,password);
        Clicking(buttonLoginElement);

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    public void clickOnMyAccount()
    {
        Clicking(myAccountElement);
    }

}
