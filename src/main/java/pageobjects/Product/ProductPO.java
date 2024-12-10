package pageobjects.Product;

import helpers.AssertionHelper;
import helpers.GeneralHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.config.PropertyFileReader;

public class ProductPO {
    private AssertionHelper hardAssert;
    WebDriver driver;
    GeneralHelper selenium;
    private static final PropertyFileReader config = new PropertyFileReader();

    @FindBy (xpath = "//button[@class='btn_primary btn_inventory']")
    WebElement addToCardProduct;

    @FindBy(css = ".fa-layers-counter.shopping_cart_badge")
    WebElement QTYCart;

    @FindBy (xpath = "//button[@class='inventory_details_back_button']")
    WebElement btnBackHomepage;

    public ProductPO(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.selenium = new GeneralHelper(driver);
        this.hardAssert = new AssertionHelper(driver);
    }
    public void clickProduct (String Product){
        selenium.clickOn(By.xpath("//div[.='"+Product+"']"));
    }

    public void addCart (){
        selenium.click(addToCardProduct);
    }

    public void VerifyQTY (String Qty){
        hardAssert.assertElementDisplayed(QTYCart);
        hardAssert.assertElementText(QTYCart,Qty);
    }

    public void BackHomepage(){
        selenium.click(btnBackHomepage);
    }
}
