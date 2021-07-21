package com.IntBanking.TestCases;

import java.io.IOException;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.IntBanking.PageObjects.DepositPage;
import com.IntBanking.PageObjects.LoginPage;

public class TC_DepositTest_09 extends BaseClass
{

	@Test
	public void depositTest() throws IOException, InterruptedException
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

		DepositPage dp=new DepositPage(driver);

		dp.clickDeposit();
		dp.enterAccountNumber("92799");

		String amt=randomestring1();
		dp.enterAmount(amt);
		logger.info(amt);

		String descp=randomestring2();
		dp.enterDescription(descp);
		logger.info(descp);

		dp.clickDepositSubmit();

		Thread.sleep(3000);
		logger.info("validation started....");

		boolean res=driver.getPageSource().contains("Transaction details of Deposit for Account");

		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");

		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"deposit");
			Assert.assertTrue(false);
		}
	}

	private String randomestring1() {
		// TODO Auto-generated method stub
		String generatedstring=RandomStringUtils.randomNumeric(4);
		return(generatedstring);
	}

	private String randomestring2() {
		// TODO Auto-generated method stub
		String generatedstring=RandomStringUtils.randomAlphabetic(7);
		return(generatedstring);
	}
}
