package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper
{
 
	public static String captureScreeshot(WebDriver driver,String screeshotname)
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destination="D:\\PERSONAL-DOC\\Selenium-Trials\\com.learnautomation.hybrid\\Screenshots\\"+screeshotname+System.currentTimeMillis()+".png";
		
		try
		{
			FileUtils.copyFile(src, new File(destination));
		} 
		catch (IOException e)
		{
		  System.out.println("failer to capture the screebshot"+e.getMessage());
		}
		
		return destination;
		
	}
}
