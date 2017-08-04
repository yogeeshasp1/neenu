package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{

	WebDriver driver;
	
	public HomePage(WebDriver Idriver)
	{
		this.driver=Idriver;
		
	}
	
	@FindBy(xpath=".//a[text()='Sign In']") WebElement SigninLink ;
	@FindBy(how=How.XPATH, using=".//a[text()='My Account']") WebElement MyaccountLink;
	@FindBy(xpath="html/body/div[1]/div/div/div[2]/div/ul/li[3]/a") WebElement MycartLink ;
	@FindBy(xpath="html/body/div[1]/div/div/div[2]/div/ul/li[4]/a") WebElement CheckoutLink;
	
	public void clickOnsignInButton()
	{
		SigninLink.click();
		/* this is click the sihnin link */
	}
	
	public void clickOnmyAccount()
	{
		SigninLink.click();
	}
	
	public void clickonMycartLink()
	{
		MycartLink.click();
	}
	public void clickOnmyAccountLink()
	{
		CheckoutLink.click();
	}
	
	public String getApplicationTittle()
	{
		return driver.getTitle();
	}
	
	
}
