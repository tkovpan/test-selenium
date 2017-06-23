import com.google.common.io.Files;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task9 {
    public EventFiringWebDriver driver;
    // public WebDriver driver;

    @Before
    public void start() {
        //ChromeDriverManager.getInstance().setup();
        //driver = new ChromeDriver();
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new MyListener());
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    private boolean IsElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    @Test
    public void all_sections() {
        driver.get("http://localhost/litecart/admin/");
        //driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"box-login\"]/form/div[2]/button")).click();


        List<WebElement> AllElements = driver.findElements(By.xpath("//*[@id=\"box-apps-menu\"]/li"));

        for (int i = 0; i < AllElements.size(); i++) {
            AllElements = driver.findElements(By.xpath("//*[@id=\"box-apps-menu\"]/li"));
            AllElements.get(i).click();
            if (IsElementPresent(By.xpath("//*[@id=\"main\"]/h1"))) {
                System.out.println("Element is Present");

            } else {
                System.out.println("Element is Absent");
            }

            List<WebElement> AllSubElements = driver.findElements(By.xpath("//*[@class=\"docs\"]/li"));

            for (int j = 0; j < AllSubElements.size(); j++) {
                AllSubElements = driver.findElements(By.xpath("//*[@class=\"docs\"]/li"));
                AllSubElements.get(j).click();
                if (IsElementPresent(By.xpath("//*[@id=\"main\"]/h1"))) {
                    System.out.println("Element is Present");

                } else {
                    System.out.println("Element is Absent");
                }

            }

        }
    }

        public static class MyListener extends AbstractWebDriverEventListener {
            @Override
            public void beforeFindBy(By by, WebElement element, WebDriver driver) {
                System.out.println(by + "before");
            }
            @Override
            public void afterFindBy(By by, WebElement element, WebDriver driver) {
                System.out.println(by + "after");
            }
            @Override
            public void onException(Throwable throwable, WebDriver driver) {
                //System.out.println(throwable);

                File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    Files.copy(tempFile, new File("screen" + System.currentTimeMillis() + ".png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @After
        public void stop() {
        driver.quit();
        }
    }


