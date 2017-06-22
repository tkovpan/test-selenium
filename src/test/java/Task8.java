import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

        driver.findElement(By.cssSelector("a[href*='http://localhost/litecart/admin/?app=countries&doc=countries']")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/form/table/tbody/tr[1]/td[7]")).click();

        //Link #1
        String parentLink1 = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@id=\"main\"]/form/div[1]/div[2]/label/a/i")).click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        driver.close();
        driver.switchTo().window(parentLink1);
        //Link #2
        String parentLink2 = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@id=\"main\"]/form/div[2]/div[1]/label/a/i")).click();

        for (String winHandle : driver.getWindowHandles()) {
           driver.switchTo().window(winHandle);
        }

        driver.close();
        driver.switchTo().window(parentLink2);

        //Link #3
        String parentLink3 = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@id=\"main\"]/form/div[3]/div[2]/label/a/i")).click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.close();
        driver.switchTo().window(parentLink3);

        //Link #4
        String parentLink4 = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@id=\"main\"]/form/div[4]/div/label/a[2]/i")).click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.close();
        driver.switchTo().window(parentLink4);


        //Link #5
        String parentLink5 = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@id=\"main\"]/form/div[5]/div[1]/label/a/i")).click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.close();
        driver.switchTo().window(parentLink5);

        //Link #6
        String parentLink6 = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@id=\"main\"]/form/div[5]/div[2]/label/a/i")).click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.close();
        driver.switchTo().window(parentLink6);

        //Link #7
        String parentLink7 = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@id=\"main\"]/form/div[5]/div[3]/label/a/i")).click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.close();
        driver.switchTo().window(parentLink7);
    }
    @After
    public void stop() {
        driver.quit();
    }
}

