package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.GetDataProviderFactory;
import pages.HomePage;

public class VerifyHomePage 
{
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver =BrowserFactory.getBrowser("firefox");
		driver.get(GetDataProviderFactory.getConfig().getApplicationUrl());
		
	}
	
    @Test
	public void testHomepage()
	{
		HomePage home=PageFactory.initElements(driver,HomePage.class);
        String title=home.getApplicationTittle();
        
        Assert.assertTrue(title.contains("Store"));
        System.out.println("the application tittle is "+title);
        
	}
    
    @AfterMethod
    public void tearDown()
    {
    	BrowserFactory.closeBrowser(driver);
    }
}
