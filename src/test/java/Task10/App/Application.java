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

import java.util.concurrent.TimeUnit;

public class Application {

    private WebDriver driver;

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
    }


    public void quit() {

        driver.quit();
    }

    public void addProducts(AddProductPage productsInCart) {

        addProducts.open(baseUrl);

        mainPage.popularProducts.click();
        mainPage.OpenDuck.click();

        addProducts.AddCartProduct.click();
        addProducts.selectYellowDuck();
        addProducts.CloseProductPage.click();

        mainPage.quantityItemBefore();
    }

    public void removeProducts(RemoveProductsPage productsOutOfCart) {
        removeProducts.OpenCart.click();
        removeProducts.RemoveProducts.click();
        removeProducts.table();
        removeProducts.BackToMainPage.click();

        mainPage.quantityItemAfter();
    }
}