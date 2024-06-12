package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	
	public Properties pro;
	
	public ReadConfig() {
		
		try {
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//Configuration//Config.properties");
			pro=new Properties();
			pro.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public  String getUrl() {
		String baseUrl=pro.getProperty("baseurl");
		return baseUrl;
	}
	
	public String getName() {
		String getUserName=pro.getProperty("username");
		return getUserName;
	}
	
	public String getCode() {
		String getPassCode=pro.getProperty("password");
		return getPassCode;
	}
	
	public String getChrome() {
		String getChromedriver=pro.getProperty("chromedriver");
		return getChromedriver;
	}
	
	public String getFirefox() {
		String getFirefoxDriver=pro.getProperty("geckodriver");
		return getFirefoxDriver;
	}
	
	

}
