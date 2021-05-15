package gutencode;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Gutenberg {

	public boolean testcase1(WebDriver driver, String expected, String shelfName, String keySearch)
			throws MalformedURLException, IOException {

		boolean flag = false;
		if (driver.getTitle().equals(expected)) {
			// System.out.println(count);
			List<WebElement> options = driver.findElements(By.cssSelector("a[href*='/ebooks/']"));
			for (WebElement option : options) {
				if (option.getText().equalsIgnoreCase("Bookshelves")) {
					System.out.println("Pointing towards the Bookshelves Dropdown in 'Search and Browse' !!!!");
					System.out.println("");
					option.click();
					List<WebElement> options1 = driver.findElements(By.cssSelector("a[href*='/ebooks/']"));
					for (WebElement option1 : options1) {
						if (option1.getText().equalsIgnoreCase(shelfName)) {
							System.out.println("Selecting " + shelfName + " from the options present !!!!");
							System.out.println("");
							option1.click();
							driver.findElement(By.id("menu-book-search")).sendKeys(keySearch);
							driver.findElement(By.cssSelector("input[type='submit'")).click();
							while (driver.findElement(By.cssSelector("a[title='Go to the next page of results.'"))
									.isDisplayed() && flag == false) {
								List<WebElement> options2 = driver.findElements(By.cssSelector("li[class='booklink'"));
								for (WebElement option2 : options2) {
									// System.out.println(option2.getText());
									if (option2.getText().contains(keySearch)) {
										System.out.println("Searching for  " + keySearch + " until found !!!!");
										System.out.println("");
										option2.click();
										List<WebElement> options4 = driver
												.findElements(By.cssSelector("a[class='link'"));
										for (WebElement option4 : options4) {
											if (option4.getText().contains("Read this book")) {

												String url = option4.getAttribute("href");
												System.out.println("Searching  found !!!!");
												System.out.println("");
												boolean result = brokenlink.Testlink(url);
												if (result) {

													flag = true;
													driver.navigate().back();

													return flag;
												}
												return flag;
											}
										}
										break;
									}
								}
								driver.findElement(By.cssSelector("a[title='Go to the next page of results.'")).click();
							}
							break;
						}
					}
					break;
				}
			}
		}

		return flag;

	}
}
