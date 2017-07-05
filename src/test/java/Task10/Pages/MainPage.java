package Task10.Pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void popularProducts(){
         driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a")).click();
 }

    public void openDuck(int i){
         //driver.findElement(By.xpath("//*[@id=\"box-popular-products\"]/div/div["+i+"]")).click();
         List<WebElement> AllDucks = driver.findElements(By.xpath("//*[@id=\"box-popular-products\"]/div/div"));
         AllDucks.get(i).click();
    }
    public int GetCartValue() throws InterruptedException {
        Thread.sleep(1000);
        //wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"cart\"]/a/div/div[2]/span[1]"), String.valueOf(i)));

        String currentCartValue =  driver.findElement(By.className("quantity")).getText();
        return Integer.parseInt(currentCartValue);
    }
       public void openCart(){
       driver.findElement(By.xpath("//*[@id=\"cart\"]/a/div")).click();
    }
  }

