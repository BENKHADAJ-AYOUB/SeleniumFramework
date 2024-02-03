package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserRegistrationPage extends PageBase{
    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }
    //private By genderMale = By.id("gender-male");
    @FindBy(id = "gender-male")
    private WebElement genderMaleElement;
    //private By firstName = By.id("FirstName");
    @FindBy(id = "FirstName")
    private WebElement firstNameElement;
    //private By LastName = By.id("LastName");
    @FindBy(id = "LastName")

    private WebElement LastNameElement;
    //private By emailField = By.id("Email");
    @FindBy(id = "Email")
    private WebElement emailFieldElement;
    //private By passwordField = By.id("Password");
    @FindBy(id = "Password")
    private WebElement passwordFieldElement;
    //private By rePasswordField = By.id("ConfirmPassword");
    @FindBy(id = "ConfirmPassword")
    private WebElement rePasswordFieldElement;
    //private By registerButton = By.id("register-button");
    @FindBy(id = "register-button")
    private WebElement registerButtonElement;

    //public By msgRegistrationComplet = By.xpath("//*[text()='Your registration completed']");
    @FindBy(css = "div.result")
    public WebElement msgRegistrationCompletElement ;

    //public By logOut = By.cssSelector("a.ico-logout");
    @FindBy(css = "a.ico-logout")
    public WebElement logOutElement ;

    //button continue

    //Créer une méthode qui permert de faire registrer
    public void UserRegistration(String fName,String lName, String mail,String pswd,String rePswd)  {

        Clicking(genderMaleElement);
        sendText(firstNameElement,fName);
        sendText(LastNameElement,lName);
        sendText(emailFieldElement,mail);
        sendText(passwordFieldElement,pswd);
        sendText(rePasswordFieldElement,rePswd);
        Clicking(registerButtonElement);

    }
    public void logOut()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.result")));
        Clicking(logOutElement);


    }


}
