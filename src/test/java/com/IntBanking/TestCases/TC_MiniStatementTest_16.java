package com.IntBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.IntBanking.PageObjects.LoginPage;
import com.IntBanking.PageObjects.MiniStatement;

public class TC_MiniStatementTest_16 extends BaseClass
{
	@Test
	public void MiniStatementTest() throws IOException, InterruptedException
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

		MiniStatement msp=new MiniStatement(driver);

		msp.clickMiniStmt();
		msp.enterAccountNo("92799");
		msp.clickMiniStmtSubmit();

		Thread.sleep(3000);
		logger.info("validation started....");

		boolean res=driver.getPageSource().contains("Last Five Transaction Details for Account No:");

		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");

		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"Mini Statement");
			Assert.assertTrue(false);
		}
	}
}	