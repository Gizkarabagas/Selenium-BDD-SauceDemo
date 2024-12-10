package utilities.pageobjectmanager;

import org.openqa.selenium.WebDriver;
import pageobjects.login.LoginPO;
import pageobjects.login.ProductPagePO;

public class PageObjectManager {
    private final WebDriver driver;
    private LoginPO loginPO;
    private  ProductPagePO productPagePO;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPO getLoginPage() {
        if (loginPO == null) {
            loginPO = new LoginPO(driver);
        }
        return loginPO;
    }

    public ProductPagePO getProductPage() {
        if (productPagePO == null) {
            productPagePO = new ProductPagePO(driver);
        }
        return productPagePO;
    }
}
