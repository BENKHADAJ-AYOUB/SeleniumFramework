package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
    //qui vas jouer avec les element
    protected WebDriver driver;
    public JavascriptExecutor jse;

    public  Select select;

    public Actions actions;
    //<1>
    //Create constructor
    public PageBase(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
    //static on peut l'appeler sans créer une instance de la classe
    protected static void Clicking(WebElement element)
    {
        element.click();
    }
    protected static void sendText(WebElement element,String text)
    {
        element.sendKeys(text);
    }
    public void scrollToBottom()
    {
        jse.executeScript("scrollBy(0,2500)");
    }
    public void clearInput(WebElement element)
    {
        element.clear();
    }
}
