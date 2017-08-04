package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider 
{
	Properties pro;
	
	public ConfigDataProvider()
	{
		File src = new File("./Configration/config.properties");
		FileInputStream fis;
		try
		{
			fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) 
		{
			System.out.println(" the exception is " +e.getMessage());
			
		}
		
		
	}
	
	public String getApplicationUrl()
	{
		String Url=pro.getProperty("url");
		return Url;
	}
	
	public String getChromepath()
	{
		String chromePath= pro.getProperty("chromePath");
		return chromePath;
	}
	
	public String getIEpath()
	{
		String IEpath= pro.getProperty("IEpath");
		return IEpath;
	}
	
	
	

}
