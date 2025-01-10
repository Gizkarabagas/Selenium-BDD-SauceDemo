package pageobjects.cart;

import helpers.AssertionHelper;
import helpers.GeneralHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.config.PropertyFileReader;

import java.util.List;

public class CartPO {
    private final GeneralHelper selenium;
    private final AssertionHelper seleniumAssert;
    WebDriver driver;
    private static final PropertyFileReader config = new PropertyFileReader();
    // Elements
    @FindBy(id = "shopping_cart_container")
    WebElement cartIcon;
    @FindBy(className = "inventory_item_name")
    List<WebElement> cartItems;
    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;
    @FindBy(className = "inventory_item_desc")
    WebElement productDesc;
    @FindBy(className = "inventory_item_price")
    WebElement productPrice;
    @FindBy(id = "checkout")
    WebElement checkoutButton;
    private final By removeButton = By.xpath("//button[text()='Remove']");
    public CartPO(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.selenium = new GeneralHelper(driver);
        this.seleniumAssert = new AssertionHelper(driver);
    }

    public void clickCartIcon() {
        selenium.click(cartIcon);
    }

    public void clickAddToCartOnSpecificItem(String itemName) {
        String addToCartButtonXpath = "//div[text()='"+itemName+"']/parent::a/parent::div/following-sibling::div//button";
        WebElement addToCartButton = driver.findElement(By.xpath(addToCartButtonXpath));
        selenium.click(addToCartButton);
    }

    public void verifyCartProductName(String expectedProductName) {
        boolean found = cartItems.stream()
                .anyMatch(item -> item.getText().contains(expectedProductName));
        seleniumAssert.assertTrue(found, expectedProductName);
    }

    public void verifyAllItemsInCart(List<String> expectedProductNames) {
        clickCartIcon();

        List<String> actualProductNames = cartItems.stream()
                .map(WebElement::getText)
                .toList();
        // Verify the total product displayed as expected
        seleniumAssert.assertEqualsInt(actualProductNames.size(), expectedProductNames.size());

        // Verify all available product name is as expected
        for (String expectedProductName : expectedProductNames) {
            seleniumAssert.assertTrue(actualProductNames.contains(expectedProductName),
                    "Expected product not found in cart: " + expectedProductName);
        }

        // Verify no other product existed in the cart
        for (String actualProductName : actualProductNames) {
            seleniumAssert.assertTrue(expectedProductNames.contains(actualProductName),
                    "Unexpected product found in cart: " + actualProductName);
        }
    }
    public void removeItemFromCart(String itemName) {
        clickCartIcon();
        for (WebElement item : cartItems) {
            if (item.getText().contains(itemName)) {
                WebElement itemRemoveButton = item.findElement(removeButton);
                selenium.click(removeButton);
                break;
            }
        }
    }

    public void verifyItemNotInCart(String itemName) {
        List<String> actualProductNames = cartItems.stream()
                .map(WebElement::getText)
                .toList();

        seleniumAssert.assertTrue(!actualProductNames.contains(itemName),
                "Item should not be present in the cart: " + itemName);
    }
    public void verifyCartBadgeNotDisplayed(){
        seleniumAssert.isElementNotDisplayed(cartBadge);
    }
    public void verifyProductDetailsOnCart(String expectedProductName){
        verifyCartProductName(expectedProductName);
        seleniumAssert.assertElementDisplayed(productDesc);
        seleniumAssert.assertElementDisplayed(productPrice);
    }
    public void clickCheckoutButton(){
        selenium.click(checkoutButton);
    }
    public void verifyCheckoutButtonIsDisabled(){
        seleniumAssert.assertElementIsDisabled(checkoutButton);
    }
    public void verifyCartBadge(String Qty) {
        seleniumAssert.assertElementDisplayed(cartBadge);
        seleniumAssert.assertElementText(cartBadge, Qty);
    }
}
