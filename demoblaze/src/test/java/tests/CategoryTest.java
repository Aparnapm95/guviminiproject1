package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;

@Listeners(listeners.TestListener.class)
public class CategoryTest extends BaseTest  {
	@DataProvider(name = "categories")
    public Object[][] categories() {
        return new Object[][] {
            { "Phones" },
            { "Laptops" },
            { "Monitors" }
        };
    }

    @Test(dataProvider = "categories", description = "Verify products display correctly for each category")
    public void testCategoryDisplaysProducts(String category) {
        HomePage home = new HomePage(driver);

        test.info("Selecting category: " + category);
        home.selectCategory(category);

        String header = home.getCategoryHeader();
        test.info("Page header shows: " + header);
        Assert.assertEquals(header, category, "Category header mismatch");

        List<String> products = home.getAllProductNames();
        test.info("Found products: " + products);
        Assert.assertTrue(products.size() > 0, "No products displayed for category: " + category);

        test.pass("Category '" + category + "' displays " + products.size() + " products.");
    }
}
