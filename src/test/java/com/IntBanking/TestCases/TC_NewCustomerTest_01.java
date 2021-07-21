package com.IntBanking.TestCases;

import java.io.IOException;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.IntBanking.PageObjects.LoginPage;
import com.IntBanking.PageObjects.NewCustomerPage;

public class TC_NewCustomerTest_01 extends BaseClass
{
	
	@Test
	public void newCustomerTest() throws IOException, InterruptedException
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

		NewCustomerPage ncp=new NewCustomerPage(driver);

		ncp.clickAddNewCustomer();
		
		String name="Customer "+randomestring();
		ncp.enterCustomerName(name);
		logger.info(name);
		
		ncp.selectGender();
		ncp.setDOB("10-","15-","1985");
		Thread.sleep(3000);
		ncp.enterAddress("INDIA");
		ncp.enterCity("HYD");
		ncp.enterState("AP");
		ncp.enterPIN("5000074");
		ncp.enterMobNo("987890091");

		String email=randomestring()+"@gmail.com";
		ncp.enterEmail(email);

		ncp.enterPassword("abcdef");
		logger.info("Check1");
		ncp.clickSubmit();
		logger.info("Check2");

		Thread.sleep(3000);
		logger.info("validation started....");

		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");

		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");

		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}

	private String randomestring() {
		// TODO Auto-generated method stub
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return(generatedstring);
	}
}