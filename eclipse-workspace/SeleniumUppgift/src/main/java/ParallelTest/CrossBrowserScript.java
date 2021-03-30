package ParallelTest;
import java.util.concurrent.TimeUnit;


/*******************************************************************************************
 * CrossBrowserScript - Launches the browser based on Parameter Passed such as
 * Chrome, Firefox & Microsoft Edge Browser
 *
 *******************************************************************************************/


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CrossBrowserScript {


	WebDriver driver;

	@SuppressWarnings("deprecation")
	public WebDriver setup(String browser) throws Exception{
		//Launches Firefox Browser
		if(browser.equalsIgnoreCase("firefox")){

			System.setProperty("webdriver.gecko.driver", "/geckodriver");
			driver = new FirefoxDriver();
		}
		//Launches Chrome Browser
		else if(browser.equalsIgnoreCase("chrome")){

			System.setProperty("webdriver.chrome.driver", "/chromedriver");

			driver = new ChromeDriver();
		}
		//Launches MsEdge Browser
		else if(browser.equalsIgnoreCase("msedge")){

			System.setProperty("webdriver.edge.driver", "/msedgedriver");

		   driver = new EdgeDriver();
		}
		//Incorrect Browser
		else{
			throw new Exception("Browser is not correct");
		}
		
		driver.manage().deleteAllCookies();
        driver.get("https://login.mailchimp.com/signup/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		driver.manage().window().maximize();

		return driver;

	}

}
