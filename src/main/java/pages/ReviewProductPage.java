package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewProductPage extends PageBase{
    public ReviewProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "AddProductReview_Title")
    private WebElement reviewTitleElement;
    @FindBy(id = "AddProductReview_ReviewText")
    private WebElement reviewTextElement;
    @FindBy(id = "addproductrating_4")
    private WebElement radioReviewElement;

    @FindBy(css = "button.button-1.write-product-review-button")
    private WebElement buttonReviewElement;

    @FindBy(css = "div.result")
    public WebElement msgSuccesReviewElement;

    public void sendReview(String titleAvis,String textAvis)
    {

        sendText(reviewTitleElement,titleAvis);

        sendText(reviewTextElement,textAvis);

        Clicking(radioReviewElement);

        Clicking(buttonReviewElement);

    }


}
