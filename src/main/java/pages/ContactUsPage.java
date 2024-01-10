package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "FullName")
    WebElement FullNameElement ;
    @FindBy(id = "Email")
    WebElement emailElement ;
    @FindBy(id = "Enquiry")
    WebElement enquiryElement;
    @FindBy(name = "send-email")
    WebElement buttonSendMailElement ;

    @FindBy(css = "div.result")
    public WebElement msgMailSendedElement ;

    public void contactUs(String fName, String mail, String message)
    {
        sendText(FullNameElement,fName);
        sendText(emailElement,mail);
        sendText(enquiryElement,message);
        Clicking(buttonSendMailElement);
    }

}


