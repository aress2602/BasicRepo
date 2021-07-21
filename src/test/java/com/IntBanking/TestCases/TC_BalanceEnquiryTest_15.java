package com.IntBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.IntBanking.PageObjects.BalanceEnquiryPage;
import com.IntBanking.PageObjects.LoginPage;

public class TC_BalanceEnquiryTest_15 extends BaseClass
{
	@Test
	public void BalanceEnquiryTes() throws IOException, InterruptedException
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

		BalanceEnquiryPage bep=new BalanceEnquiryPage(driver);

		bep.clickBalEnquiry();
		bep.enterAccountNo("92799");
		bep.clickBalEnquirySubmit();

		Thread.sleep(3000);
		logger.info("validation started....");

		boolean res=driver.getPageSource().contains("Balance Details for Account");

		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");

		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"Balance Enquiry");
			Assert.assertTrue(false);
		}
	}
}	