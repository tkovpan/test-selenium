package Task10;


import org.openqa.selenium.By;

public class Links {

    public String baseURL = "http://localhost/litecart";
    public By POPULAR_PRODUCTS = By.xpath("//*[@id=\"content\"]/ul/li[2]/a");
    public By OPEN_DUCK = By.xpath("//*[@id=\"box-popular-products\"]/div/div");
    public By ADD_CART_PRODUCT = By.name("add_cart_product");
    public By CLOSE_PRODUCT_PAGE = By.xpath("/html/body/div[2]/div/button");
    public By OPEN_CART = By.xpath("//*[@id=\"cart\"]/a/div");
    public By REMOVE_PRODUCTS = By.name("remove_cart_item");
    public By BACK_TO_MAINPAGE = By.xpath("//a[contains (text(), '<< Back')]");
    public By TABLE_PRESENT = By.xpath("//*[@id=\"box-checkout-cart\"]/h2");
    public By Items = By.className("quantity");

}
