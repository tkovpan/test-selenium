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
    @FindBy(xpath = "//*[@id=\\\"cart\\\"]/a/div")
    public WebElement OpenCart;

    @FindBy(name = "remove_cart_item")
    public WebElement RemoveProducts;

   @FindBy(xpath = "//*[@id=\"box-checkout-cart\"]/div/table/tbody/tr[1]")
    public WebElement tableIsNotPresent;

    @FindBy(xpath = "//a[contains (text(), '<< Back')]")
    public WebElement BackToMainPage;

    public void table() {
        WebElement table1 = driver.findElement(By.xpath("//*[@id=\"box-checkout-cart\"]/div/table/tbody/tr[1]"));
        wait.until(ExpectedConditions.stalenessOf(table1));
    }
}