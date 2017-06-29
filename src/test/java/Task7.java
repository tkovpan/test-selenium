import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
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
        wait = new WebDriverWait(driver, 2);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
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
            if (isElementPresent(By.xpath("//*[@id=\"box-product\"]/div[1]/div[3]/div/div[4]/form/div[1]/select"))) {
                Select select = new Select(driver.findElement(By.name("options[Size]")));
                select.selectByValue("Small");
            }

            driver.findElement(By.name("add_cart_product")).click();

            driver.findElement(By.xpath("/html/body/div[2]/div/button")).click();



            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"cart\"]/a/div/div[2]/span[1]"), String.valueOf(i + 1)));

        }

        driver.findElement(By.xpath("//*[@id=\"cart\"]/a/div")).click();

        for (; ; ) {
            wait.until(ExpectedConditions.elementToBeClickable(By.name("remove_cart_item"))).click();


            WebElement table = driver.findElement(By.xpath("//*[@id=\"box-checkout-cart\"]/div/table/tbody/tr[1]"));
            wait.until(ExpectedConditions.stalenessOf(table));



            if (!isElementPresent(By.xpath("//*[@id=\"box-checkout-cart\"]/h2"))) {
                driver.findElement(By.cssSelector("a[href*='http://localhost/litecart/en/']")).click();
                break;
            }
        }

                String items = driver.findElement(By.className("quantity")).getCssValue("item(s)-");
                Assert.assertEquals("", items);
            }

    @After
    public void stop() {
        driver.quit();
    }
}

