import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task8 {
    public WebDriver driver;


    @Before
    public void start() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void login_admin() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"box-login\"]/form/div[2]/button")).click();

        driver.findElement(By.xpath("//span[contains(text(), 'Countries')]")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/ul/li/a")).click();

        List<WebElement> AllLinks = driver.findElements(By.xpath("//label/a/i"));

       for(int i = 0; i < AllLinks.size(); i++){
            AllLinks = driver.findElements(By.xpath("//label/a/i"));
            AllLinks.get(i).click();
           String parentLink = driver.getWindowHandle();
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }
           driver.close();
           driver.switchTo().window(parentLink);
        }
    }

    @After
    public void stop() {
        driver.quit();
    }
}
