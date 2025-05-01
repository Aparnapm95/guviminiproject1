package tests;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;

@Listeners(listeners.TestListener.class)
public class AddToCartTest extends BaseTest {
	@DataProvider(name = "productSelection")
    public Object[][] productSelection() {
        return new Object[][] {
            { "Phones", "Samsung galaxy s6" },
            { "Laptops", "Sony vaio i5" }
        };
    }

    @Test(dataProvider = "productSelection", description = "Verify user can add product to cart")
    public void testAddToCart(String category, String productName) {
        HomePage home = new HomePage(driver);
        ProductDetailsPage details = new ProductDetailsPage(driver);

        // 1. Select category and verify
        test.info("Selecting category: " + category);
        home.selectCategory(category);
        Assert.assertEquals(home.getCategoryHeader(), category, "Category header mismatch");

        // 2. Click on the specified product
        test.info("Clicking product: " + productName);
        List<String> products = home.getAllProductNames();
        Assert.assertTrue(products.contains(productName), "Product not listed: " + productName);
        driver.findElement(
            By.xpath("//a[text()='" + productName + "']")
        ).click();

        // 3. Verify product details page
        String displayedTitle = details.getProductTitle();
        test.info("Product details title: " + displayedTitle);
        Assert.assertEquals(displayedTitle, productName, "Product title mismatch");

        String price = details.getProductPrice();
        test.info("Product price: " + price);
        Assert.assertTrue(price.startsWith("$"), "Price format incorrect");

        // 4. Add to cart and handle alert
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
    }
}
