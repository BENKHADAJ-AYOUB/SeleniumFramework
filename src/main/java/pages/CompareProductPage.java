package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CompareProductPage extends PageBase{
    public CompareProductPage(WebDriver driver) {
        super(driver);
    }
    //Clear List
    @FindBy(css = "a.clear-list")
    private WebElement clearProductElement;
    //noData
    @FindBy(css = "div.no-data")
    private WebElement noElementToCompareElement;

    //Table
    @FindBy(css = "table.compare-products-table")
    private WebElement tableElement;
    //Les ligne de la table
    @FindBy(tagName = "tr")
    public List<WebElement> ligneTableElement;
    //Les colones de la table
    @FindBy(tagName = "td")
    public List<WebElement> colonTableElement;
    //Asus name
    @FindBy(linkText = "Asus N551JK-XO076H Laptop")
    public WebElement secondProductElement;
    //Mac name
    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    public WebElement firstProductElement;
    //Méthode pour supprimer une product de la table compar
    public void removeProductCompareTable()
    {
        Clicking(clearProductElement);
    }
    public void compareProduct()
    {
        //get all ligne
        System.out.println(ligneTableElement.size());
        //get Data from eaach row
        for (WebElement ligne :ligneTableElement)
        {
            System.out.println(ligne.getText()+"\t");
            for (WebElement col:colonTableElement)
            {

                System.out.println(col.getText()+"\t");
            }
        }
    }
}
