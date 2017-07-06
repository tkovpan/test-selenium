package Task10.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddProductPage extends Page {

    public AddProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void open(String baseUrl) {
        driver.get(baseUrl);
    }
    private boolean isElementPresent(By locator) {

        return driver.findElements(locator).size() > 0;
    }
    public void addToCart(){
            if (isElementPresent(By.name("options[Size]"))) {
            Select select = new Select(driver.findElement(By.name("options[Size]")));
            select.selectByValue("Small");
        }

        driver.findElement(By.name("add_cart_product")).click();
    }
    public void closeProductPage(){
        driver.findElement(By.xpath("/html/body/div[2]/div/button")).click();
    }
 }


