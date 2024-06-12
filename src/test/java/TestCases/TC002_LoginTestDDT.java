package TestCases;

import javax.annotation.concurrent.ThreadSafe;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Utilities.ExcelLibrary;

public class TC002_LoginTestDDT extends BaseClass {
	
	
ExcelLibrary ex=new ExcelLibrary();
	
	@Test(dataProvider="excelDDT")
	public void TC002_LoginTest(String us, String pw) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		logger.info("enter username");
		lp.guserName(us);
		logger.info("enter password");
		lp.gpassWord(pw);
		logger.info("submit button");
		lp.logIn();
		Thread.sleep(2000);
		if(isAlertPresent()==true) {
		Assert.assertTrue(false);
		System.out.println("test case failed");
		logger.info("test case failed");
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
			}else {
				Thread.sleep(2000);
				Assert.assertTrue(true);
				System.out.println("test case passed");
				logger.info("test case passed");
				lp.logoutButton();
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
			}
		
		}
	
	@DataProvider(name="excelDDT")
	public Object [][] dataInput(){
		return new Object[][] 
				
				{{ex.excelLib("Sheet1", 0, 0),ex.excelLib("Sheet1", 0, 1)},
				{ex.excelLib("Sheet1", 1, 0),ex.excelLib("Sheet1", 1, 1)},
				{ex.excelLib("Sheet1", 2, 0),ex.excelLib("Sheet1", 2, 1)},
				{ex.excelLib("Sheet1", 3, 0),ex.excelLib("Sheet1", 3, 1)},
				{ex.excelLib("Sheet1", 4, 0),ex.excelLib("Sheet1", 4, 1)},
				{ex.excelLib("Sheet1", 5, 0),ex.excelLib("Sheet1", 5, 1)},
				
				};		
	}
}
