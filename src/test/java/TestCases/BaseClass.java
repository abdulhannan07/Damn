package TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Utilities.ReadConfig;

public class BaseClass {
	//adding first comment
	public static  ReadConfig rd=new ReadConfig();
	
	public static Logger logger;
	
	public static WebDriver driver;
	
	public static String baseurl=rd.getUrl();
	public String username=rd.getName();
	public String password=rd.getCode();
	
	@BeforeClass
	public void enterUrl() {
		
		logger=Logger.getLogger("selenium project");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.gecko.driver", rd.getFirefox());
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		logger.info("enter url");
		driver.get(baseurl);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void closeUrl() {
		logger.info("close driver");
		driver.quit();
	}
	
	
	public void getScreenShot(WebDriver driver,String testname) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;	
	File source=ts.getScreenshotAs(OutputType.FILE);
	File des=new File(System.getProperty("user.dir")+"//Screenshots//"+testname+".png");
	FileUtils.copyFile(source, des);
	System.out.println("Screenshot taken");
	
	
	}
	
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch
			(NoAlertPresentException e) {
			return false;
		}
	}

}
