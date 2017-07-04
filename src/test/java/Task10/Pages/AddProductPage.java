package Task10.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddProductPage extends Page {
    public WebDriverWait wait;

    public AddProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open(String baseUrl) {

        driver.get(baseUrl);
    }

    private boolean isElementPresent(By name) {

        return true;
    }

    @FindBy(name = "add_cart_product")
    public WebElement AddCartProduct;

    @FindBy(xpath = "/html/body/div[2]/div/button")
    public WebElement CloseProductPage;

    @FindBy(name = "options[Size]")
    public WebElement selectDuck;

    public void selectYellowDuck() {
        if (isElementPresent(By.name("options[Size]"))) {
            Select select = new Select(driver.findElement(By.name("options[Size]")));
            select.selectByValue("Small");


        }
    }
}
