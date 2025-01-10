package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.cart.CartPO;
import pageobjects.product.ProductPO;
import utilities.config.PropertyFileReader;
import utilities.drivermanager.GetDriverManager;
import utilities.pageobjectmanager.PageObjectManager;

import java.util.List;

public class CartSteps {
    private WebDriver driver;
    private PageObjectManager pageObjectManager;
    private static final PropertyFileReader config = new PropertyFileReader();
    private CartPO cartPage;
    private ProductPO productPage;

    public CartSteps() {
        this.driver = GetDriverManager.getDriver(config.getBrowser());
        this.pageObjectManager = new PageObjectManager(driver);
        this.cartPage = pageObjectManager.getCartPage();
        this.productPage = pageObjectManager.getProductPage();
    }

    @Then("the cart badge shows {string} item")
    public void theCartBadgeShowsItem(String cartBadge) {
        cartPage.verifyCartBadge(cartBadge);

    }

    @When("the user adds the following items to the cart:")
    public void theUserAddsTheFollowingItemsToTheCart(List<String> productsNameList) {
        for (String productName : productsNameList) {
            cartPage.clickAddToCartOnSpecificItem(productName);
        }
    }

    @And("the cart contains")
    public void theCartContains(List<String> expectedItems) {
        cartPage.verifyAllItemsInCart(expectedItems);
    }

    @When("the user removes the following item")
    public void theUserRemovesTheFollowingItem(List<String> items) {
        for (String item : items) {
            cartPage.removeItemFromCart(item);
        }
    }

    @Then("the cart badge shows no items")
    public void theCartBadgeShowsNoItems() {
        cartPage.verifyCartBadgeNotDisplayed();
    }

    @And("the cart does not contain {string}")
    public void theCartDoesNotContain(String itemName) {
        cartPage.verifyItemNotInCart(itemName);

    }

    @When("the user views the cart")
    public void theUserViewsTheCart() {
        cartPage.clickCartIcon();
    }

    @Then("the cart page displays {string} product details")
    public void theCartPageDisplaysProductDetails(String itemName) {
        cartPage.verifyProductDetailsOnCart(itemName);
    }

    @Given("the cart is empty")
    public void theCartIsEmpty() {
        cartPage.verifyCartBadgeNotDisplayed();
    }

    @When("the user attempts to proceed to checkout")
    public void theUserAttemptsToProceedToCheckout() {
        cartPage.clickCartIcon();
        cartPage.clickCheckoutButton();
    }

    @Then("the user is prevented from proceeding checkout")
    public void theUserIsPreventedFromProceedingCheckout() {

    }
}
