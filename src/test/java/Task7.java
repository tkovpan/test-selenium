import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task7 {
    public WebDriver driver;
    public WebDriverWait wait;


    @Before
    public void start() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        //FirefoxDriverManager.getInstance().setup();
        //driver = new FirefoxDriver();
        //InternetExplorerDriverManager.getInstance().setup();
        //driver = new InternetExplorerDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    @Test
    public void all_sections() throws InterruptedException {

        driver.get("http://localhost/litecart");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a")).click();

        List<WebElement> AllDucks = driver.findElements(By.xpath("//*[@id=\"box-popular-products\"]/div/div"));

        for (int i = 0; i < 3; i++) {

            driver.findElement(By.xpath("//*[@id=\"box-popular-products\"]/div/div"));
            AllDucks.get(i).click();
            if (driver.findElement(By.xpath("//*[@id=\"box-popular-products\"]")).getText().equals("Yellow Duck")) {
                Select select = new Select(driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[1]/div[3]/div/div[4]/form/div[1]/select")));
                select.selectByValue("Small");
                }
            Thread.sleep(500);
            driver.findElement(By.name("add_cart_product")).click();
            Thread.sleep(100);
            driver.findElement(By.xpath("/html/body/div[2]/div/button")).click();

            Thread.sleep(100);

            wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//*[@id=\"cart\"]/a/div/div[2]/span[1]"), String.valueOf(i + 1)));
            Thread.sleep(100);
        }

        driver.findElement(By.xpath("//*[@id=\"cart\"]/a/div")).click();

        for (; ; ) {
            wait.until(ExpectedConditions.elementToBeClickable(By.name("remove_cart_item"))).click();


            WebElement table = driver.findElement(By.xpath("//*[@id=\"box-checkout-cart\"]/div/table/tbody/tr[1]"));
            wait.until(ExpectedConditions.stalenessOf(table));
            Thread.sleep(500);

            if (!isElementPresent(By.xpath("//*[@id=\"box-checkout-cart\"]/h2"))) {
                driver.findElement(By.cssSelector("a[href*='http://localhost/litecart/en/']")).click();


            String items = driver.findElement(By.className("quantity")).getCssValue("item(s)-");
            Assert.assertEquals("", items);
            }
        }
    }
}