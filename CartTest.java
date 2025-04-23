package tests;

import org.testng.annotations.Test;

import pages.CartPage;
import utils.BaseClass;

public class CartTest extends BaseClass{
	@Test
    public void verifyCartAndUpdateQuantity() {
        CartPage cart = new CartPage(driver);
        cart.goToCart();
        cart.updateQuantity("2");

        assert driver.getPageSource().contains("Your Shopping Cart");
    }

}
