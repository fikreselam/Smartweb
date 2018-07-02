package SmartWeb.SmartWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearch {

	private static String Google_Text_Box = "q";
	private static String keyword;
	private WebElement element;
	private WebDriver driver;

	public GoogleSearch(String keyword) {
		this.keyword = keyword;
		Intialize();
	}

	private void Intialize() {
		// creating new instance of firefox
		System.setProperty("webdriver.gecko.driver", "C:\\gecko/geckodriver.exe");

		driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		element = driver.findElement(By.name(Google_Text_Box));
	}

	public void startSearch() {
		element.sendKeys(keyword);
		element.submit();
		System.out.println("page title is: " + driver.getTitle());
		waitDriver();
		System.out.println("page title is: " + driver.getTitle());
		// driver.quit();
	}

	private void waitDriver() {
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("cheese");
			}
		});
	}

}
