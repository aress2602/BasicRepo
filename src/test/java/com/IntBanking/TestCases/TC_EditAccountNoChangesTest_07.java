package com.IntBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.IntBanking.PageObjects.EditAccountPage;
import com.IntBanking.PageObjects.LoginPage;

public class TC_EditAccountNoChangesTest_07 extends BaseClass
{
	@Test
	public void EditAccountNoChangesTest() throws IOException, InterruptedException
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

		//		Switching to Alert
		Alert alert=driver.switchTo().alert();

		//		Capturing Alert message
		String alertMessage=driver.switchTo().alert().getText();

		//		Displaying Alert message
		logger.info(alertMessage);

		Thread.sleep(3000);
		// Accepting Alert		
		alert.accept();

		if(driver.getTitle().equals("Guru99 Edit Account Page"))
		{
			Assert.assertTrue(true);
			logger.info("PASS");
		}
		else
		{
			logger.info("failed");
			captureScreen(driver,"EditAccountNoChanges");
			Assert.assertTrue(false);
		}
	}
}
