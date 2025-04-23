package tests;

import org.testng.annotations.Test;

import pages.ProductPage;
import utils.BaseClass;

public class ProductTest extends BaseClass{
	 @Test
	    public void browseAndAddToCart() {
	        ProductPage product = new ProductPage(driver);
	        product.selectCategory("Books");
	        product.selectProduct("Fiction");
	        product.addToCart();

	        assert driver.getPageSource().contains("The product has been added to your shopping cart");
	

}
}
