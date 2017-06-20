import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class Task5 {
    public WebDriver driver;


    @Before
    public void start() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        //FirefoxDriverManager.getInstance().setup();
        //driver = new FirefoxDriver();
        //InternetExplorerDriverManager.getInstance().setup();
        //driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void all_sections() {
        driver.get("http://localhost/litecart");
        driver.findElement(By.xpath("//*[@id=\"box-campaign-products\"]/div/div/div/a")).click();

        //Product Name
        String firstName = driver.findElement(By.xpath("//*[@id=\"box-campaign-products\"]/div/div/div/a/div[2]/div[1]")).getCssValue("name");//Product Name
        String secondName = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[1]/div[2]/h1")).getCssValue("name");
        Assert.assertEquals("Yellow Duck",firstName, secondName);


        //Regular price
        String firstPrice = driver.findElement(By.xpath("//*[@id=\"box-campaign-products\"]/div/div/div/a/div[2]/div[3]/s")).getCssValue("name");//Regular price
        String secondPrice = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[1]/div[3]/div/div[1]/del")).getCssValue("name");//Regular price
        Assert.assertEquals("$20",firstPrice, secondPrice);

        //Discount Price
        String firstDiscountPrice = driver.findElement(By.xpath("//*[@id=\"box-campaign-products\"]/div/div/div/a/div[2]/div[3]/strong")).getCssValue("name");//Discount Price
        String secondDiscountPrice = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[1]/div[3]/div/div[1]/strong")).getCssValue("name");//Discount Price
        Assert.assertEquals("$18",firstDiscountPrice, secondDiscountPrice);

//Main page
        if (driver instanceof ChromeDriverManager) {

            String priceColorMP = driver.findElement(By.className("regular-price")).getCssValue("color");
            Assert.assertEquals("rgba(51, 51, 51, 1)", priceColorMP);//Chrome,IE
            String pricestrikeFF = driver.findElement(By.className("regular-price")).getCssValue("text-decoration");
            Assert.assertEquals("line-through solid rgb(51, 51, 51)", pricestrikeFF);//Chrome
            String priceColorDiscount = driver.findElement(By.className("campaign-price")).getCssValue("color");
            Assert.assertEquals("rgba(204, 0, 0, 1)", priceColorDiscount);//Chrome
            String pricestrike1 = driver.findElement(By.className("campaign-price")).getCssValue("font-weight");
            Assert.assertEquals("bold", pricestrike1);//Chrome
        }
        if (driver instanceof FirefoxDriverManager) {
            String priceColorFF = driver.findElement(By.className("regular-price")).getCssValue("color");
            Assert.assertEquals("rgb(51, 51, 51)", priceColorFF);
            String pricestrikeFF = driver.findElement(By.className("regular-price")).getCssValue("text-decoration");
            Assert.assertEquals("line-through solid rgb(51, 51, 51)", pricestrikeFF);
            String priceColorItPageFF = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[1]/div[3]/div/div[1]/del")).getCssValue("color");
            Assert.assertEquals("rgb(51, 51, 51)", priceColorItPageFF);
            String pricestrike1FF = driver.findElement(By.className("campaign-price")).getCssValue("font-weight");
            Assert.assertEquals("700", pricestrike1FF);//FF, IE
        }
        if (driver instanceof InternetExplorerDriverManager) {
            String priceColorMP = driver.findElement(By.className("regular-price")).getCssValue("color");
            Assert.assertEquals("rgba(51, 51, 51, 1)", priceColorMP);//Chrome,IE
            String pricestrikeFF = driver.findElement(By.className("regular-price")).getCssValue("text-decoration");
            Assert.assertEquals("line-through solid rgb(51, 51, 51)", pricestrikeFF);
            String priceColorItPageFF = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[1]/div[3]/div/div[1]/del")).getCssValue("color");
            Assert.assertEquals("rgb(51, 51, 51)", priceColorItPageFF);
            String pricestrike1FF = driver.findElement(By.className("campaign-price")).getCssValue("font-weight");
            Assert.assertEquals("700", pricestrike1FF);//FF, IE
        }
// Item page

        if (driver instanceof ChromeDriverManager) {

            String priceColorItPage = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[1]/div[3]/div/div[1]/del")).getCssValue("color");
            Assert.assertEquals("rgba(51, 51, 51, 1)", priceColorItPage);//Chrome,IE, //Regular price color
            String pricestrikeFF1 = driver.findElement(By.className("regular-price")).getCssValue("text-decoration");
            Assert.assertEquals("line-through solid rgb(51, 51, 51)", pricestrikeFF1);//Chrome
            String priceColor2 = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[1]/div[3]/div/div[1]/strong")).getCssValue("color");
            Assert.assertEquals("rgba(204, 0, 0, 1)", priceColor2);//Chrome
            String pricestrike11FF = driver.findElement(By.className("campaign-price")).getCssValue("font-weight");
            Assert.assertEquals("700", pricestrike11FF);//FF, IE

            if (driver instanceof FirefoxDriverManager) {
                String priceColorItPage1 = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[1]/div[3]/div/div[1]/del")).getCssValue("color");
                Assert.assertEquals("rgba(51, 51, 51, 1)", priceColorItPage1);//Chrome,IE, //Regular price color
                String pricestrikeFF = driver.findElement(By.className("regular-price")).getCssValue("text-decoration");
                Assert.assertEquals("line-through solid rgb(51, 51, 51)", pricestrikeFF);//Chrome
                String priceColor = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[1]/div[3]/div/div[1]/strong")).getCssValue("color");
                Assert.assertEquals("rgba(204, 0, 0, 1)", priceColor);//Chrome
                String pricestrike1FF = driver.findElement(By.className("campaign-price")).getCssValue("font-weight");
                Assert.assertEquals("700", pricestrike1FF);//FF, IE
            }
            if (driver instanceof InternetExplorerDriverManager) {
                String priceColorItPage2 = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[1]/div[3]/div/div[1]/del")).getCssValue("color");
                Assert.assertEquals("rgba(51, 51, 51, 1)", priceColorItPage2);//Chrome,IE, //Regular price color
                String pricestrikeFF = driver.findElement(By.className("regular-price")).getCssValue("text-decoration");
                Assert.assertEquals("line-through solid rgb(51, 51, 51)", pricestrikeFF);//Chrome
                String priceColor = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[1]/div[3]/div/div[1]/strong")).getCssValue("color");
                Assert.assertEquals("rgba(204, 0, 0, 1)", priceColor);//Chrome
                String pricestrike1FF = driver.findElement(By.className("campaign-price")).getCssValue("font-weight");
                Assert.assertEquals("700", pricestrike1FF);//FF, IE
            }


        }

    }

    @After
    public void stop() {
        driver.quit();
    }
}

