package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmalFriendPage extends PageBase{
    public EmalFriendPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FriendEmail")
    WebElement emailFriendElement ;
    @FindBy(id = "PersonalMessage")
    WebElement msgElement;
    @FindBy(name = "send-email")
    WebElement buttonSendMailElement ;

    @FindBy(css = "div.result")
    public WebElement succesMsgFreindlyElement ;
    public void sendEmailToFriend(String mailFriend, String msgPerso)
    {

        sendText(emailFriendElement,mailFriend);

        sendText(msgElement,msgPerso);

        Clicking(buttonSendMailElement);

    }
}
