package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.Product.ProductPO;
import utilities.drivermanager.GetDriverManager;
import utilities.pageobjectmanager.PageObjectManager;
import utilities.config.PropertyFileReader;

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
}