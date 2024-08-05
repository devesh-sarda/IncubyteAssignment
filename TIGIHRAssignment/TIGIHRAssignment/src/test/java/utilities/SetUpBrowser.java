package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SignUpBasePage;

public class SetUpBrowser
{		
	/**
	 * Setting up the Chrome browser
	 * @param driver
	 */
	WebDriver driver;
	SignUpBasePage base = new SignUpBasePage(driver);
	
	public WebDriver setUpChrome()
	{
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        return driver;
	}
	
	/**
	 * Closing the browser
	 */
	public void closeBrowser()
	{
		driver.quit();
	}
}