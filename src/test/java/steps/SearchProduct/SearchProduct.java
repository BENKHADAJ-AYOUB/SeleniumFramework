package steps.SearchProduct;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import tests.TestBase;

public class SearchProduct extends TestBase {
    HomePage homePage;
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    String productName ="Apple MacBook Pro 13-inch";

    @Given("the user in the home page for search product")
    public void the_user_in_the_home_page_for_search_product() {
        homePage = new HomePage(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("demo.nopcommerce.com"));
    }
    @When("I entered name product and click on search")
    public void i_entered_name_product_and_click_on_search() {
        searchPage = new SearchPage(driver);
        searchPage.productSerch(productName);
    }

    @When("i click on the product")
    public void i_click_on_the_product() {
        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.clickOnProductTitle();
    }

    @Then("The details product page displayed successfully")
    public void the_details_product_page_displayed_successfully() {
        Assert.assertTrue(productDetailsPage.productTitleElement.getText().contains(productName));


    }
}
