package Task10;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public LoginPage open(String baseUrl) {
        driver.get(baseUrl);
        return this;
    }
}
