package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.Product.ProductPO;
import utilities.drivermanager.GetDriverManager;
import utilities.pageobjectmanager.PageObjectManager;
import utilities.config.PropertyFileReader;

import java.util.List;
import java.util.Map;

public class ProductPageSteps {
    private WebDriver driver;
    private PageObjectManager pageObjectManager;
    private static final PropertyFileReader config = new PropertyFileReader();
    private ProductPO  productpage;

    public ProductPageSteps() {
        // Get the PageObjectManager from Hooks
        this.driver = GetDriverManager.getDriver(config.getBrowser());
        this.pageObjectManager = new PageObjectManager(driver);
        this.productpage = pageObjectManager.getProductPage();
    }
    @When("user select {string}")
    public void user_select(String SauceLabsBackpack) {
        productpage.clickProduct(SauceLabsBackpack);
    }
    @When("user add to cart")
    public void user_add_to_cart() {
        productpage.addCart();
    }

    @Then("user verify QTY {string}")
    public void userVerifyQTY(String cart) {
        productpage.VerifyQTY(cart);
    }

    @And("user back homepage")
    public void userBackHomepage() {
        productpage.BackHomepage();
    }

    @Then("verify all product")
    public void verifyAllProduct(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> form : data) {
            String product = form.get("Sauce Labs Backpack");
            String product1 = form.get("Sauce Labs Bike Light");
            String product2 = form.get("Sauce Labs Bolt T-Shirt");
            String product3= form.get("Sauce Labs Fleece Jacket");
            String product4 = form.get("Sauce Labs Onesie");
            String product5 = form.get("Test.allTheThings() T-Shirt (Red)");

            productpage.allproduct(("Sauce Labs Backpack"),product);
            productpage.allproduct(("Sauce Labs Bike Light"), product1);
            productpage.allproduct(("Sauce Labs Bolt T-Shirt"), product2);
            productpage.allproduct(("Sauce Labs Fleece Jacket"), product3);
            productpage.allproduct(("Sauce Labs Onesie"), product4);
            productpage.allproduct(("Test.allTheThings() T-Shirt (Red)"), product5);

        }
    }

    @Then("user remove cart")
    public void userRemoveCart() {
        productpage.removeCartProduct();
    }

    @Then("cart empty")
    public void cartEmpty() {
        Assert.assertTrue(productpage.cartEmpty());
    }
}