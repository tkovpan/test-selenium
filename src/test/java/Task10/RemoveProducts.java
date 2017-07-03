package Task10;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveProducts extends Page {
    public RemoveProducts(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open(String baseUrl) {
        driver.get(baseUrl);
    }
    @FindBy(xpath = "OPEN_CART")
    public WebElement OPEN_CART;

    @FindBy(xpath = "REMOVE_PRODUCTS")
    public WebElement REMOVE_PRODUCTS;

    @FindBy(xpath = "BACK_TO_MAINPAGE")
    public WebElement BACK_TO_MAINPAGE;

}