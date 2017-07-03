import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class Task6 {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void login_admin() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"box-login\"]/form/div[2]/button")).click();

        //General
        driver.findElement(By.xpath("//span[contains(text(), 'Catalog')]")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]/div/div[1]/div[4]/div/div/div[1]/label/input")).click();
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]/div/div[1]/div[5]/input")).sendKeys("06/21/2017");
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]/div/div[2]/div[1]/input")).sendKeys("Test Code");
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]/div/div[2]/div[2]/div/input")).sendKeys("Test Task6");
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]/div/div[2]/div[3]/div[1]/input")).sendKeys("Test SKU");
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]/div/div[2]/div[3]/div[2]/input")).sendKeys("Test GTIN");
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]/div/div[2]/div[3]/div[3]/input")).sendKeys("Test TARIC");
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]/div/div[2]/div[3]/div[3]/input")).sendKeys("Test TARIC");
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]/div/div[2]/div[4]/div/div[1]/input")).sendKeys(Keys.DELETE + "5");
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]/div/div[2]/div[5]/div/input")).sendKeys(Keys.DELETE + "2");
        driver.findElement(By.xpath("//*[@id=\"images\"]/div[2]/div/div[2]/input"));
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("image.jpg").getFile());
        driver.findElement(By.xpath("//*[@id=\"images\"]/div[2]/div/div[2]/input")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]/div/div[1]/div[1]/div/div/label[1]")).click();

        //Information
        driver.findElement(By.xpath("//*[@id=\"main\"]/form/div/ul/li[2]/a")).click();
        Select manufacturer = new Select(driver.findElement(By.xpath("//*[@id=\"tab-information\"]/div[1]/div[1]/select")));
        manufacturer.selectByIndex(1);
        driver.findElement(By.xpath("//*[@id=\"tab-information\"]/div[2]/div/input")).sendKeys("Test Keyword");
        driver.findElement(By.xpath("//*[@id=\"tab-information\"]/div[3]/div/div/input")).sendKeys("Test Short Description");
        driver.findElement(By.xpath("//*[@id=\"tab-information\"]/div[4]/div/div/div/div[2]")).sendKeys("Test Description");
        driver.findElement(By.xpath("//*[@id=\"tab-information\"]/div[5]/div/div/textarea")).sendKeys("Test Attributes");
        driver.findElement(By.xpath("//*[@id=\"tab-information\"]/div[6]/div[1]/div/input")).sendKeys("Test Head Title");
        driver.findElement(By.xpath("//*[@id=\"tab-information\"]/div[6]/div[2]/div/input")).sendKeys("Test Meta Description");


        //Prices
        driver.findElement(By.xpath("//*[@id=\"main\"]/form/div/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"prices\"]/div/div[1]/div/input")).sendKeys("15");
        Select purchasePrice = new Select(driver.findElement(By.xpath("//*[@id=\"prices\"]/div/div[1]/div/select")));
        purchasePrice.selectByIndex(2);
        driver.findElement(By.xpath("//*[@id=\"prices\"]/table/tbody/tr[1]/td[1]/div/input")).sendKeys("777");
        driver.findElement(By.xpath("//*[@id=\"main\"]/form/p/button[1]")).click();

        // Verification
       driver.findElement(By.xpath("//a[contains (text(), 'Rubber Ducks')]")).click();


wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"main\"]/form/table/tbody"), "Test Task6"));

        String newProduct = driver.findElement(By.xpath("//*[@id=\"main\"]/form/table/tbody")).getText();
       Assert.assertEquals("Test Task6", newProduct);

    }

    @After
    public void stop() {
        driver.quit();
    }
}
