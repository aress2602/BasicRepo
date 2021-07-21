package com.IntBanking.TestCases;

import java.io.IOException;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.IntBanking.PageObjects.LoginPage;
import com.IntBanking.PageObjects.NewAccountPage;

public class TC_NewAccountTest_05 extends BaseClass
{
	@Test
	public void newAccountTest() throws IOException, InterruptedException
	{
		driver.get(baseURL);
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is entered");
		lp.setPassword(password);
		logger.info("Password is entered");
		lp.clickSubmit();

		Thread.sleep(3000);
		NewAccountPage nap=new NewAccountPage(driver);
		nap.clickAddAccount();
		logger.info("clicked link");
		nap.enterAccountCustomerID("85344");
		logger.info("customer ID entered");
		
		Select drpAcctType=new Select(driver.findElement(By.xpath("//select[@name='selaccount']")));
		drpAcctType.selectByValue("Current");
		
		String initdep=randomestring();
		nap.enterIntialDeposit(initdep);
		logger.info(initdep);
		
		nap.clickAddAccountSubmit();
		
		Thread.sleep(3000);
		logger.info("validation started....");

		boolean res=driver.getPageSource().contains("Account Generated Successfully!!!");

		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addAccount");
			Assert.assertTrue(false);
		}
	}
	
	private String randomestring() {
		// TODO Auto-generated method stub
		String generatedstring=RandomStringUtils.randomNumeric(5);
		return(generatedstring);
	}
}
