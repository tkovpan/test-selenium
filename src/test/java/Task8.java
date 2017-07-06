import com.sun.java.swing.plaf.windows.resources.windows;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Task8 {
    public WebDriver driver;
    public WebDriverWait wait;


    @Before
    public void start() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 4);
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

        for (int i = 0; i < AllLinks.size(); i++) {
            String originalW = driver.getWindowHandle();
            Set<String> existWs = driver.getWindowHandles();
            AllLinks = driver.findElements(By.xpath("//label/a/i"));
            AllLinks.get(i).click();
            String newW = wait.until(anyWindowOtherThan(existWs));
            driver.switchTo().window(newW);
            driver.close();
            driver.switchTo().window(originalW);
        }
    }
    public ExpectedCondition<String> anyWindowOtherThan(Set<String> windows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver input) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(windows);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }
    @After
    public void stop() {
        driver.quit();
    }
}


