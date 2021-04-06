package ParallelTest;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CrossBrowserScript {


	 WebDriver driver;

	@SuppressWarnings("deprecation")
	public WebDriver setup(String browser) throws Exception{

		if(browser.equalsIgnoreCase("firefox")){

			System.setProperty("webdriver.gecko.driver", "/geckodriver");
			driver = new FirefoxDriver();
		}

		else if(browser.equalsIgnoreCase("chrome")){

			System.setProperty("webdriver.chrome.driver", "/chromedriver");

			driver = new ChromeDriver();
		}

		else if(browser.equalsIgnoreCase("msedge")){

			System.setProperty("webdriver.edge.driver", "/msedgedriver");

			driver = new EdgeDriver();
		}

		else{
			throw new Exception("Browser is not correct");
		}
		
		driver.get("https://login.mailchimp.com/signup/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
		
	}

}
