package com.IntBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.IntBanking.PageObjects.EditAccountPage;
import com.IntBanking.PageObjects.LoginPage;

public class TC_EditAccountTest_06 extends BaseClass
{
	@Test
	public void editAccountTest() throws IOException, InterruptedException
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
		EditAccountPage eaccp=new EditAccountPage(driver);
		eaccp.clickEditAccount();
		logger.info("clicked link");
		eaccp.enterAccountNo("92799");
		logger.info("account no entered");

		eaccp.clickEditAccountSubmit();

		Select drpEditAcctType=new Select(driver.findElement(By.xpath("//select[@name='a_type']")));
		drpEditAcctType.selectByValue("Savings");

		eaccp.clickEditAccountSave();

		boolean res=driver.getPageSource().contains("Account details updated Successfully!!!");

		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"EditAccount");
			Assert.assertTrue(false);
		}
	}
}
