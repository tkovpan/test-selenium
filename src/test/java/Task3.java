import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;


public class Task3 {
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
        //driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        //driver.findElement(By.name("login")).click();
        //driver.findElement(By.xpath(".//*[@name='login']")).click();
        driver.findElement(By.xpath("//*[@id=\"box-login\"]/form/div[2]/button")).click();
    }
    @After
    public void stop() {
        driver.quit();
    }
}
