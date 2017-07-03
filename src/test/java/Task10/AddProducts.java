package Task10;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddProducts extends Page {
    public AddProducts(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void open(String baseUrl) {
        driver.get(baseUrl);
    }

    @FindBy(xpath = "POPULAR_PRODUCTS")
    public WebElement POPULAR_PRODUCTS;

    @FindBy(xpath = "OPEN_DUCK")
    public WebElement OPEN_DUCK;

    @FindBy(xpath = "ADD_CART_PRODUCT")
    public WebElement ADD_CART_PRODUCT;

    public void selectYellowDuck(String yellowDuck){
        wait.until((WebDriver d) -> d.findElement(
                By.cssSelector(String.format("select[name=Small] options[Size]", yellowDuck))));
        new Select(driver.findElement(By.cssSelector("select[name=Small"))).selectByValue(yellowDuck);
    }

    @FindBy(xpath = "CLOSE_PRODUCT_PAGE")
    public WebElement CLOSE_PRODUCT_PAGE;
}