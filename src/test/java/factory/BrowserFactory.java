package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import dataProvider.ConfigDataProvider;

public class BrowserFactory 
{
	static WebDriver driver;
	
	//ConfigDataProvider config= new ConfigDataProvider();
	public static WebDriver getBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("Chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", GetDataProviderFactory.getConfig().getChromepath());
			driver=new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("IE"))
		{
			
			System.setProperty("webdriver.ie.driver", GetDataProviderFactory.getConfig().getIEpath());
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}

}
