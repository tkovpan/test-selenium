package Task10.Test;


import Task10.Pages.AddProductPage;
import Task10.Pages.RemoveProductsPage;

public class Test extends TestBase {

   @org.junit.Test

    public void addAndRemoveProducts(AddProductPage products) {

       for (; ; ) {
           app.addProducts(products);
       }
   }
    public void addAndRemoveProducts(RemoveProductsPage products) {
        for(; ;){
            app.removeProducts(products);
        }
    }
}
