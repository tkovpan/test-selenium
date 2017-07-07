package Task10.Test;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestProducts extends TestBase {

    @Test
    public void addAndRemoveProducts() {
        app.OpenPopularPage();
        for (int i = 0; i < 3; i++) {
            int Count = app.GetCurrentValue();
            app.AddProducts();
           Assert.assertEquals(Count + 1, app.GetCurrentValue());
        }
        app.OpenCart();
        app.RemoveAllProducts();
        Assert.assertEquals(0, app.GetCurrentValue());
    }
    }
