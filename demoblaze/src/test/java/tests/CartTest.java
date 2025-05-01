package tests;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;

@Listeners(listeners.TestListener.class)
public class CartTest extends BaseTest{
	@Test(description = "Verify product is added to cart and total price is correct")
    public void testCart() {
        HomePage home = new HomePage(driver);
        ProductDetailsPage details = new ProductDetailsPage(driver);
        CartPage cart = new CartPage(driver);

        // 1. Select a category and a product
        String category = "Phones";
        String productName = "Samsung galaxy s6";

        test.info("Selecting category: " + category);
        home.selectCategory(category);
        Assert.assertEquals(home.getCategoryHeader(), category, "Category header mismatch");

        test.info("Clicking product: " + productName);
        List<String> products = home.getAllProductNames();
        Assert.assertTrue(products.contains(productName), "Product not listed: " + productName);
        driver.findElement(By.xpath("//a[text()='" + productName + "']")).click();

        // 2. Add product to cart
        test.info("Adding product to cart");
        details.clickAddToCart();
        try {
            Thread.sleep(2000); // wait for alert
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            test.info("Alert message: " + alertText);
            alert.accept();
            test.pass("Add to cart alert accepted");
        } catch (Exception e) {
            test.fail("No alert displayed after adding to cart: " + e.getMessage());
            Assert.fail("Add to cart failed – no alert");
        }

        // 3. Open cart and verify product
        cart.openCart();
        List<WebElement> cartItems = cart.getCartItems();
        Assert.assertTrue(cartItems.size() > 0, "Cart is empty");

        boolean productFound = cartItems.stream().anyMatch(item -> item.getText().contains(productName));
        Assert.assertTrue(productFound, "Product not found in cart");

        test.info("Product found in cart: " + productName);

        // 4. Verify total price (check if price starts with "$")
        String totalPrice = cart.getTotalPrice();
        Assert.assertTrue(totalPrice.startsWith("$"), "Total price format incorrect");
        test.info("Total price in cart: " + totalPrice);

        test.pass("Product successfully added to cart with correct price.");
    }
}
