package SmartWeb.SmartWeb;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

	private static WebDriver driver = null;
	private static final String HubUrl = "http://localhost:4444/";

	public static WebDriver getDriver() {
		String os = System.getProperty("os.name").toLowerCase();
		if (driver == null) {
			driver = new ChromeDriver();
		}

		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		}

		return driver;
	}
	
	public static WebDriver getHubDriver() throws MalformedURLException {
		DesiredCapabilities capability = DesiredCapabilities.chrome();
	
		
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		return driver;
	}

}
