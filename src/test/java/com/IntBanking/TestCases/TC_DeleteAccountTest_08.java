package com.IntBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.IntBanking.PageObjects.DeleteAccountPage;
import com.IntBanking.PageObjects.LoginPage;

public class TC_DeleteAccountTest_08 extends BaseClass
{
	@Test
	public void deleteAccountTest() throws IOException, InterruptedException
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is entered");
		lp.setPassword(password);
		logger.info("Password is entered");
		lp.clickSubmit();

		Thread.sleep(3000);

		DeleteAccountPage dap=new DeleteAccountPage(driver);

		dap.clickDeleteAccount();
		logger.info("Clicked Delete link");
		dap.enterdAccountNo("92800");
		logger.info("Entered Account No");
		dap.clickdeleteAccountSubmit();
		logger.info("Submit clicked");

		Alert alert1=driver.switchTo().alert();
		String alert1Message=driver.switchTo().alert().getText();
		logger.info(alert1Message);
		Thread.sleep(3000);
		alert1.accept();
		
		Alert alert2=driver.switchTo().alert();
		String alert2Message=driver.switchTo().alert().getText();
		logger.info(alert2Message);
		Thread.sleep(3000);
		alert2.accept();
	
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("PASS");
		}
		else
		{
			logger.info("failed");
			captureScreen(driver,"DeleteAccount");
			Assert.assertTrue(false);
		}
	}
}

