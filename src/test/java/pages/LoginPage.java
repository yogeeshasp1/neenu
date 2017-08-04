package pages;

import javax.swing.text.Element;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
{
	WebDriver driver;
	
	public LoginPage(WebDriver Idriver)
	{
		this.driver=Idriver;
	  
	}
	
	@FindBy(xpath=".//*[@id='account_sign_in_form_email_id']") WebElement Username;
	@FindBy(xpath=".//*[@id='account_sign_in_form_passwd_id']") WebElement Password;
	@FindBy(xpath=".//input[@value='Sign In']") WebElement SignInButton;
	
	//@FindBy(xpath=".//div[@class='pre-header']//a[text()='Sign Out']") WebElement SignOutButton;
	By SignOut=By.xpath(".//div[@class='pre-header']//a[text()='Sign Out']");
	
	
	public void LoginApplication(String username,String password)
	{
		Username.sendKeys(username);
		Password.sendKeys(password);
		SignInButton.click();
	}
	
	public void VerifySignOutLink()
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(SignOut));
		String Signouttext=ele.getText();
		System.out.println(Signouttext);
		Assert.assertEquals(Signouttext, "Sign Out");

		
	}
	


}
