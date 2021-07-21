package com.IntBanking.TestCases;

import java.io.IOException;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.IntBanking.PageObjects.FundTransferPage;
import com.IntBanking.PageObjects.LoginPage;

public class TC_FTAccountNotExistTest_13 extends BaseClass
{
	@Test
	public void FTAccNotExistTest() throws IOException, InterruptedException
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
		ftp.enterPayersAccount("926");
		ftp.enterPayeesAccount("92601");
		
		String amt=randomestring1();
		ftp.enterAmount(amt);
		logger.info(amt);

		String descp=randomestring2();
		ftp.enterDesc(descp);
		logger.info(descp);

		ftp.clickFTSubmit();

		Thread.sleep(3000);

		Alert alert=driver.switchTo().alert();
		String alertMessage=driver.switchTo().alert().getText();
		logger.info(alertMessage);

		Thread.sleep(3000);
		alert.accept();

		if(driver.getTitle().equals("Guru99 Bank Fund Transfer Entry Page"))
		{
			Assert.assertTrue(true);
			logger.info("PASS");
		}
		else
		{
			logger.info("failed");
			captureScreen(driver,"Fund Transfer Acc Not Exist");
			Assert.assertTrue(false);
		}
	}

	private String randomestring1() {
		// TODO Auto-generated method stub
		String generatedstring=RandomStringUtils.randomNumeric(3);
		return(generatedstring);
	}

	private String randomestring2() {
		// TODO Auto-generated method stub
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return(generatedstring);
	}
}

