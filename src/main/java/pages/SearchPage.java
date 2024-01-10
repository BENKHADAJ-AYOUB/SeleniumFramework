package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends PageBase{

    public SearchPage(WebDriver driver) {
        super(driver);
    }
    //By inputSerach =  By.id("small-searchterms");
    @FindBy(id = "small-searchterms")
    WebElement inputSerachElement;
    //By buttonSerach =  By.cssSelector("button.button-1.search-box-button");
    @FindBy(css = "button.button-1.search-box-button")
    WebElement buttonSerachElement;
    //By productList =  By.id("ui-id-1");
    @FindBy(id ="ui-id-1")
    List<WebElement> productListElement;



    public void productSerch(String nameProduct)
    {
        //inputSerachElement = driver.findElement(inputSerach);
        sendText(inputSerachElement,nameProduct);
        //buttonSerachElement = driver.findElement(buttonSerach);
        Clicking(buttonSerachElement);

    }

    public void productSearchUsingAutoSuggest(String nameProduct )
    {
        //inputSerachElement = driver.findElement(inputSerach);
        sendText(inputSerachElement,nameProduct);
       try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);}

        //productListElement =  driver.findElements(productList);
        productListElement.get(0).click();

    }



}
