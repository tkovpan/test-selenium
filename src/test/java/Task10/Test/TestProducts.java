package Task10.Test;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestProducts extends TestBase {

    @Test
    public void addAndRemoveProducts() throws InterruptedException {
        app.OpenPopularPage();
        for (int i = 0; i < 3; i++) {
            int currentCartValue = app.AddProducts(i);
            Assert.assertEquals(i + 1, currentCartValue);
        }
        app.OpenCart();
        app.RemoveAllProducts();
        Assert.assertEquals(0, app.getPageCount());
    }
}
