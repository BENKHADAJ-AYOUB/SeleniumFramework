package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class MyAccountPage extends PageBase{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    //private By changePassword = By.xpath("//*[text()='Change password']");
    @FindBy(xpath = "//*[text()='Change password']")
    private WebElement changePasswordElement ;

    //private By oldPassword = By.xpath("//input[@name='OldPassword']");
    @FindBy(xpath = "//input[@name='OldPassword']")
    private WebElement oldPasswordElement;

    //private By newPassword = By.xpath("//input[@id='NewPassword']");
    @FindBy(xpath = "//input[@id='NewPassword']")
    private WebElement newPasswordElement;

    //private By ConfirmNewPassword = By.xpath("//input[@name='ConfirmNewPassword']");
    @FindBy(xpath = "//input[@name='ConfirmNewPassword']")
    private WebElement ConfirmNewPasswordElement;

    //private By buttonChangePassword = By.cssSelector("button.button-1.change-password-button");
    @FindBy(css = "button.button-1.change-password-button")
    private WebElement buttonChangePasswordElement;

    //public By msgPasswordChanged = By.xpath("//p[@class='content']");
    @FindBy(xpath = "//p[@class='content']")
    public WebElement msgPasswordChangedElement;

    //By closeMsgChanged = By.cssSelector("span.close");
    @FindBy(css = "span.close")
    WebElement closeMsgChangedElement;
    public void openChangePasssword()
    {
        Clicking(changePasswordElement);
    }

    public void changePassord(String oldPswd,String newPswd)
    {

        sendText(oldPasswordElement,oldPswd);
        sendText(newPasswordElement,newPswd);
        sendText(ConfirmNewPasswordElement,newPswd);
        Clicking(buttonChangePasswordElement);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));



    }
    public void closeMsgchangedPassword()
    {

        Clicking(closeMsgChangedElement);
    }



}
