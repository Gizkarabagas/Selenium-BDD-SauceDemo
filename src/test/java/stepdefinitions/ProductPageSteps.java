package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.login.ProductPagePO;
import utilities.drivermanager.GetDriverManager;
import utilities.pageobjectmanager.PageObjectManager;
import utilities.config.PropertyFileReader;

public class ProductPageSteps {
    private WebDriver driver;
//    private PageObjectManager pageObjectManager;
    private static final PropertyFileReader config = new PropertyFileReader();
//    private ProductPagePO productpage;
    private ProductPagePO productpage = new ProductPagePO(driver);

    public ProductPageSteps() {
        // Get the PageObjectManager from Hooks
        this.driver = GetDriverManager.getDriver(config.getBrowser());
//        this.productpage = new ProductPagePO(driver);
//        this.pageObjectManager = new PageObjectManager(driver);
//        this.productpage = pageObjectManager.getProductPage();
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
}