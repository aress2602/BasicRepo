package com.IntBanking.TestCases;

import java.io.IOException;

//import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.IntBanking.PageObjects.LoginPage;

public class TC_LoginTest_01 extends BaseClass
{
	@Test
	public void loginTest() throws IOException
	{
		driver.get(baseURL);
		logger.info("URL is hit");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		logger.info("Login button clicked");
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
			System.out.println("PASS");
		}
		else
		{
			logger.info("Login test failed");
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			
			
		}
	}
}