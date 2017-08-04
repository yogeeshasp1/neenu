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
import pages.LoginPage;

public class VerifyLoginPage 
{
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver =BrowserFactory.getBrowser("firefox");
		driver.get(GetDataProviderFactory.getConfig().getApplicationUrl());
		
	}
	
    @Test
	public void testLoginPage()
	{
		HomePage home=PageFactory.initElements(driver,HomePage.class);
        String title=home.getApplicationTittle();
        
        Assert.assertTrue(title.contains("Store"));
        System.out.println("the application tittle is "+title);
        
        home.clickOnsignInButton();
       
        LoginPage logpage = PageFactory.initElements(driver, LoginPage.class);
        logpage.LoginApplication(GetDataProviderFactory.getExcel().getData(0,0,0),GetDataProviderFactory.getExcel().getData(0,0,1));
        logpage.VerifySignOutLink();
        
	}
    
    @AfterMethod
    public void tearDown()
    {
    	BrowserFactory.closeBrowser(driver);
    }
}
