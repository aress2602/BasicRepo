package com.IntBanking.TestCases;

import java.io.IOException;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
//import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.IntBanking.PageObjects.CustomisedStatementPage;
import com.IntBanking.PageObjects.LoginPage;

public class TC_CustomisedStatementTest_17 extends BaseClass
{
	@Test
	public void CustomisedStatementTest() throws IOException, InterruptedException
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

		CustomisedStatementPage csp=new CustomisedStatementPage(driver);

		csp.clickCustomStmt();
		csp.enterActNo("92799");
		
		csp.setFromDate("01-","01-","2021");
//		driver.findElement(By.xpath("//input[@name='fdate']")).click();
		Thread.sleep(3000);
		
		csp.setToDate("12-","12-","2021");
		Thread.sleep(3000);
		
		String minvalue=randomestring1();
		csp.enterMinTransValue(minvalue);
		logger.info(minvalue);
		
		String nooftrans=randomestring2();
		csp.enterNoOfTransactions(nooftrans);
		logger.info(nooftrans);
		
		csp.clickSubmit();
		
		Thread.sleep(3000);
		logger.info("validation started....");

		boolean res=driver.getPageSource().contains("Transaction Details for Account No:");

		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");

		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"CustomisedStatement");
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
		String generatedstring=RandomStringUtils.randomNumeric(4);
		return(generatedstring);
	}
}