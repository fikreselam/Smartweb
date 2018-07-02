package SmartWeb.SmartWeb;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

 import junit.*;


public class SelinumDom {

	private static WebDriver driver = null;
	@BeforeClass
	public static void BeforeCheckDataTest() throws MalformedURLException {

		driver = DriverFactory.getDriver();

		// driver.get("https://www.google.com");
		driver.get("file:///Users/fikreselamelala/Desktop/index/index.html");
		fillFormWithData();

	}
	@Test
	public  void testCheckData() {
		WebElement element = driver.findElement(By.id("fname"));
		String value = element.getAttribute("value");
		assertTrue("fikreselam".equals(value));
		System.out.println(value);
	}

	private static void fillFormWithData() {
		WebElement element = driver.findElement(By.id("fname"));
		element.sendKeys("Fikreselam");
		driver.findElement(By.id("submit")).click();
	}

	public static void findInputInLabels() {
		List<WebElement> labels = driver.findElements(By.tagName("label"));
		List<WebElement> inputs = (List<WebElement>) ((JavascriptExecutor) driver).executeScript(
				"var labels = arguments[0], inputs = []; for (var i=0; i < labels.length; i++){"
						+ "inputs.push(document.getElementById(labels[i].getAttribute('for'))); } return inputs;",
				labels);
		for (WebElement elelment : inputs) {
			System.out.println("element: " + elelment.getText());
		}

	}
}