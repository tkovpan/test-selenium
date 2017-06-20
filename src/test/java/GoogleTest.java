import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GoogleTest {
        WebDriver driver;

    @Before
    public void start() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        FirefoxDriverManager.getInstance().setup();
        System.setProperty("webdriver.chrome.driver","D:\\tools\\Drivers\\chromedriver.exe");
        driver = new FirefoxDriver();
        InternetExplorerDriverManager.getInstance().setup();
        System.setProperty("webdriver.chrome.driver","D:\\tools\\Drivers\\chromedriver.exe");
        driver = new InternetExplorerDriver();
    }
    @Test
    public void google_test()
    {
    driver.get("http://google.com");
    //driver.findElement(By.name("q")).sendKeys("webdriver");
    //driver.findElement(By.name("nbmm")).click();
    }
    @After
    public void stop() {

        driver.quit();
    }
}