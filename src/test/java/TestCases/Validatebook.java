package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import gutencode.Gutenberg;


public class Validatebook {
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {

		System.setProperty("webdriver.gecko.driver", "C:/work/geckodriver.exe");

		driver = new FirefoxDriver();
		driver.get("https://gutenberg.org/");

		System.out.println("The Browser is Initialized !!!!");
		System.out.println("");
		
	}

	@Test(timeOut = 1800000)
	public void validateBookInfo() throws IOException, InterruptedException {

		Gutenberg obj = new Gutenberg();
		boolean success = obj.testcase1(driver, "Free eBooks | Project Gutenberg", "Fiction Bookshelf", "Harry");
		Assert.assertTrue(success);
	}

	@AfterTest
	public void browserclosing() {

		driver.quit();

	}

}
