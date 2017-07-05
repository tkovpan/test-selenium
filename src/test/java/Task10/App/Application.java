package Task10.App;

import Task10.Pages.AddProductPage;
import Task10.Pages.MainPage;
import Task10.Pages.RemoveProductsPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Application {

    private WebDriver driver;
    public WebDriverWait wait;

    private AddProductPage addProducts;
    private RemoveProductsPage removeProducts;
    private MainPage mainPage;

    private String baseUrl = "http://localhost/litecart";

    public Application() {

        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        addProducts = new AddProductPage(driver);
        removeProducts = new RemoveProductsPage(driver);
        mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //wait = new WebDriverWait(driver, 10);
    }

    public void quit() {
        driver.quit();
    }

    public void OpenPopularPage() {
        addProducts.open(baseUrl);
        mainPage.popularProducts();
    }

    public int AddProducts(int i) throws InterruptedException {
        mainPage.openDuck(i);

        addProducts.addToCart();
        addProducts.closeProductPage();
        return mainPage.GetCartValue();

    }
    public void OpenCart() {
        mainPage.openCart();
           }

    public void RemoveAllProducts() {
              removeProducts.removeAllProducts();
        }

    public int getPageCount() throws InterruptedException {
        return mainPage.GetCartValue();
    }
}