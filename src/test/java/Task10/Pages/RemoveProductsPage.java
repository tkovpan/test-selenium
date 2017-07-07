package Task10.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RemoveProductsPage extends Page {
    public RemoveProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open(String baseUrl) {

        driver.get(baseUrl);
    }

    private boolean isElementPresent(By locator) {

        return driver.findElements(locator).size() > 0;
    }

    public void removeAllProducts() {

        wait.until(ExpectedConditions.elementToBeClickable (By.name("remove_cart_item")));

        for (; ; ) {

            WebElement table = driver.findElement(By.xpath("//*[@id=\"box-checkout-cart\"]/div/table/tbody/tr[1]"));
            wait.until(ExpectedConditions.elementToBeClickable(By.name("remove_cart_item"))).click();
            wait.until(ExpectedConditions.stalenessOf(table));
                break;
            }
        driver.findElement(By.xpath("//a[contains (text(), '<< Back')]")).click();
        }
    }