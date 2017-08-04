package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.GetDataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPageWithReport 
{
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp()
	{
		report= new ExtentReports(".\\Reports\\LoginPageReport.html",true);
		/* the true means refresh everytime once its true */
		logger=report.startTest("Verify LoginPage");
		//here we are start the logger test
		driver =BrowserFactory.getBrowser("firefox");
		driver.get(GetDataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "application is up and running ");
		
	}
	
    @Test
	public void testLoginPage()
	{
		HomePage home=PageFactory.initElements(driver,HomePage.class);
        String title=home.getApplicationTittle();
        
        Assert.assertTrue(title.contains("Store"));
        System.out.println("the application tittle is "+title);
        logger.log(LogStatus.PASS, "Home page loaded Succesfully and tittel verified");
        
        home.clickOnsignInButton();
        logger.log(LogStatus.INFO, "Sign In Link in clicked");
       
        LoginPage logpage = PageFactory.initElements(driver, LoginPage.class);
        logpage.LoginApplication(GetDataProviderFactory.getExcel().getData(0,0,0),GetDataProviderFactory.getExcel().getData(0,0,1));
        logpage.VerifySignOutLink();
        logger.log(LogStatus.PASS, "Sign Out link Present and Verified");
        
	}
    
    @AfterMethod
    public void tearDown(ITestResult result)
    {
    	if(ITestResult.FAILURE==result.getStatus())
    	{
    	   logger.log(LogStatus.FAIL,result.getThrowable());
    	}
    	BrowserFactory.closeBrowser(driver);
    	
    	report.endTest(logger);
    	report.flush();
    }
}
