package com.IntBanking.TestCases;

import java.io.IOException;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.IntBanking.PageObjects.FundTransferPage;
import com.IntBanking.PageObjects.LoginPage;

public class TC_FundTransferTest_14 extends BaseClass
{
	@Test
	public void FundTransferTest() throws IOException, InterruptedException
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

		FundTransferPage ftp=new FundTransferPage(driver);

		ftp.clickFindTransfer();
		ftp.enterPayersAccount("92801");
		ftp.enterPayeesAccount("92799");
		
		String amt=randomestring1();
		ftp.enterAmount(amt);
		logger.info(amt);

		String descp=randomestring2();
		ftp.enterDesc(descp);
		logger.info(descp);

		ftp.clickFTSubmit();

		Thread.sleep(3000);

		if(driver.getTitle().equals("Guru99 Bank Customised Statement Page"))
		{
			Assert.assertTrue(true);
			logger.info("PASS");
		}
		else
		{
			logger.info("failed");
			captureScreen(driver,"Fund Transfer");
			Assert.assertTrue(false);
		}
	}

	private String randomestring1() {
		// TODO Auto-generated method stub
		String generatedstring=RandomStringUtils.randomNumeric(2);
		return(generatedstring);
	}

	private String randomestring2() {
		// TODO Auto-generated method stub
		String generatedstring=RandomStringUtils.randomAlphabetic(7);
		return(generatedstring);
	}
}
