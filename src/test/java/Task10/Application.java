package Task10;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Application {

    private WebDriver driver;
    private LoginPage loginPage;
    private AddProducts addProducts;
    private RemoveProducts removeProducts;
    private MainPage mainPage;

    private String baseUrl = "http://localhost/litecart";

    public Application() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        addProducts = new AddProducts(driver);
        removeProducts = new RemoveProducts(driver);
        mainPage = new MainPage(driver);
    }


    public void quit() {
        driver.quit();
    }
    public void addProducts(AddProducts addProducts) {
        addProducts.open(baseUrl);
        addProducts.POPULAR_PRODUCTS.click();
        addProducts.OPEN_DUCK.click();
        addProducts.ADD_CART_PRODUCT.click();
        //addProducts.selectYellowDuck();
        addProducts.CLOSE_PRODUCT_PAGE.click();
    }
    public void removeProducts(RemoveProducts removeProducts) {
        removeProducts.OPEN_CART.click();
        removeProducts.REMOVE_PRODUCTS.click();
        removeProducts.BACK_TO_MAINPAGE.click();
    }
}