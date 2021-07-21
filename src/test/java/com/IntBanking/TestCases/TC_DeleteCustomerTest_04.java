package com.IntBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.IntBanking.PageObjects.DeleteCustomerPage;
import com.IntBanking.PageObjects.LoginPage;

public class TC_DeleteCustomerTest_04  extends BaseClass
{
	@Test
	public void deleteCustomerTest() throws IOException, InterruptedException
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

		DeleteCustomerPage dcp=new DeleteCustomerPage(driver);

		dcp.clickDeleteCustomer();
		logger.info("Clicked Delete link");
		dcp.enterdCustomerID("16284");
		logger.info("Entered Customer ID");
		dcp.clickdeleteCustSubmit();
		logger.info("Submit clicked");

		//		Switching to Alert
		Alert alert=driver.switchTo().alert();

		//		Capturing Alert message
		String alertMessage=driver.switchTo().alert().getText();

		//		Displaying Alert message
		logger.info(alertMessage);

		Thread.sleep(3000);
		// Accepting Alert		
		alert.accept();
	}
}
