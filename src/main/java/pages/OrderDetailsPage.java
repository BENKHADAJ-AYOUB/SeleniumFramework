package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase {
    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.button-2.print-order-button")
    WebElement printElement;
    @FindBy(css = "a.button-2.pdf-invoice-button")
    WebElement pdfInvoiceElement;

    public void printOrder() {
        Clicking(printElement);
    }

    public void pdfInvoiceOrder() {
        Clicking(pdfInvoiceElement);
    }
}
