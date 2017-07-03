package Task10;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Page{

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "Items")
    public WebElement items;

    public Integer getItemsQtty() {

        return Integer.parseInt(this.items.getText().split(": ")[0]);
    }
}
