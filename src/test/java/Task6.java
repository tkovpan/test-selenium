import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Task6 {
    public WebDriver driver;


    @Before
    public void start() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void login_admin() {
        driver.get("http://localhost/litecart/admin/");
        //driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        //driver.findElement(By.name("login")).click();
        //driver.findElement(By.xpath(".//*[@name='login']")).click();
        driver.findElement(By.xpath("//*[@id=\"box-login\"]/form/div[2]/button")).click();

        driver.findElement(By.xpath("//*[@id=\"app-\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]/div/div[1]/div[4]/div/div/div[1]")).click();

    }
}