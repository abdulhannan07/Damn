package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class TC1_LoginTest extends BaseClass {
	
	@Test
	public  void TC_LoginTest() throws InterruptedException, IOException {
		LoginPage ll=new LoginPage(driver);
		ll.guserName(rd.getName());
		logger.info("entered username");
		ll.gpassWord(rd.getCode());
		logger.info("entered password");
		ll.logIn();
		logger.info("submit login button");
		Thread.sleep(2000);
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			getScreenShot(driver,"TC1_LoginTest");
			logger.info("test case passed");
			System.out.println("test case passed");
			
		}else {
			Assert.assertTrue(false);
			logger.info("test case failed");
			System.out.println("test case failed");
			
			
		}
		ll.logoutButton();
		
		
	}

}
