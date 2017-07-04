package Task10.Test;
import org.junit.Test;

import Task10.Pages.AddProductPage;
import Task10.Pages.RemoveProductsPage;

public class TestProducts extends TestBase {

    @Test

    public void addAndRemoveProducts(AddProductPage products) {

        for (int i=0; i<3; i++) {
            app.addProducts(products);
        }
    }
    public void addAndRemoveProducts(RemoveProductsPage products) {
        for(; ;){
            app.removeProducts(products);
        }
    }
}
