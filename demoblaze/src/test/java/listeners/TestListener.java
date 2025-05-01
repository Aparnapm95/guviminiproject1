package listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;

import tests.BaseTest;

public class TestListener extends BaseTest implements ITestListener {
	 public static String takeScreenshot(WebDriver driver, String screenshotName) {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File src = ts.getScreenshotAs(OutputType.FILE);
	        String path = "test-output/screenshots/" + screenshotName + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".png";
	        try {
	            FileUtils.copyFile(src, new File(path));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return path;
	    }
}
