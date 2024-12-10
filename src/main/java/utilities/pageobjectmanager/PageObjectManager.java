package utilities.pageobjectmanager;

import org.openqa.selenium.WebDriver;
import pageobjects.login.LoginPO;
import pageobjects.Product.ProductPO;

public class PageObjectManager {
    private final WebDriver driver;
    private LoginPO loginPO;
    private  ProductPO productPagePO;

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
}
