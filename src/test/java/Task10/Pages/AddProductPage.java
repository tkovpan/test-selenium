package Task10.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class AddProductPage extends Page {

    public AddProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void open(String baseUrl) {
        driver.get(baseUrl);
    }


     private boolean isElementNotPresent(By locator) {
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
            return driver.findElements(locator).size() == 0;
        } finally {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
        }
    }
    public void addToCart() {

        wait.until(ExpectedConditions.elementToBeClickable(By.name("add_cart_product")));

        if (!isElementNotPresent(By.name("options[Size]"))) {
            Select select = new Select(driver.findElement(By.name("options[Size]")));
            select.selectByValue("Small");
        }
        WebElement qtty = driver.findElement(By.cssSelector(".quantity"));
        Integer value = Integer.valueOf(qtty.getText());
        driver.findElement(By.name("add_cart_product")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(qtty, String.valueOf(value + 1)));

           }
    public void closeProductPage(){

        driver.findElement(By.xpath("/html/body/div[2]/div/button")).click();
    }
 }


