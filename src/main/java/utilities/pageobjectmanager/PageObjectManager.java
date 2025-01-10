package utilities.pageobjectmanager;

import org.openqa.selenium.WebDriver;
import pageobjects.cart.CartPO;
import pageobjects.login.LoginPO;
import pageobjects.product.ProductPO;

public class PageObjectManager {
    private final WebDriver driver;
    private LoginPO loginPO;
    private  ProductPO productPagePO;
    private CartPO cartPO;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPO getLoginPage() {
        if (loginPO == null) {
            loginPO = new LoginPO(driver);
        }
        return loginPO;
    }

    public ProductPO getProductPage() {
        if (productPagePO == null) {
            productPagePO = new ProductPO(driver);
        }
        return productPagePO;
    }
    public CartPO getCartPage() {
        if (cartPO == null) {
            cartPO = new CartPO(driver);
        }
        return cartPO;
    }
}
