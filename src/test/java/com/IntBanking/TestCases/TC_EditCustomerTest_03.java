package com.IntBanking.TestCases;

import java.io.IOException;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.IntBanking.PageObjects.EditCustomerPage;
import com.IntBanking.PageObjects.LoginPage;


public class TC_EditCustomerTest_03 extends BaseClass
{
	@Test
	public void editCustomerTest() throws IOException, InterruptedException
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

		EditCustomerPage ecp=new EditCustomerPage(driver);

		ecp.clickEditCustomer();
		logger.info("Clicked Edit link");
		ecp.enterCustomerID("85344");
		logger.info("Entered Customer ID");
		ecp.clickCIDSubmit();
		logger.info("Submit clicked");
		ecp.enterAddress("Address edited");
		ecp.enterCity("City edited");
		ecp.enterState("State edited");
		ecp.enterPIN("9012345");
		ecp.enterMobNo("902323232");


		String email=randomestring()+"@gmail.com";
		ecp.enterEmail(email);
		ecp.clickEditCustomerSubmit();

		Thread.sleep(3000);
		logger.info("validation started....");

		boolean res=driver.getPageSource().contains("Customer details updated Successfully!!!");

		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"editCustomer");
			Assert.assertTrue(false);
		}
	}

	private String randomestring() {
		// TODO Auto-generated method stub
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return(generatedstring);
	}
}

