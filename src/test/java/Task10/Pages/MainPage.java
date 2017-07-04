package Task10.Pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open(String baseUrl) {

        driver.get(baseUrl);
    }

    @FindBy(xpath = "//*[@id=\\\"content\\\"]/ul/li[2]/a")
    public WebElement popularProducts;

    @FindBy(xpath = "//*[@id=\\\"box-popular-products\\\"]/div/div")
    public WebElement OpenDuck;

    @FindBy(className = "quantity")
    public WebElement items;

    int i = 0;
    public void quantityItemBefore() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"cart\"]/a/div/div[2]/span[1]"), String.valueOf(i + 1)));
    }
    public void quantityItemAfter() {
        driver.findElement(By.className("quantity")).getText();
        Assert.assertEquals("0", items);

    }
    }

