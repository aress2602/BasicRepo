package com.IntBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.IntBanking.PageObjects.DeleteCustomerPage;
import com.IntBanking.PageObjects.LoginPage;
import com.IntBanking.Utilities.XLUtils;

public class TC_DeleteCustomerDDT_04  extends BaseClass
{
	@Test(dataProvider="DeleteCustomer")
	public void deleteCustomerDDT(String user,String pwd,String customerid,String exp) throws IOException, InterruptedException
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Username is entered");
		lp.setPassword(pwd);
		logger.info("Password is entered");
		lp.clickSubmit();

		Thread.sleep(3000);

		DeleteCustomerPage dcp=new DeleteCustomerPage(driver);

		dcp.clickDeleteCustomer();
		logger.info("Clicked Delete link");
		dcp.enterdCustomerID(customerid);
		logger.info(customerid);
		dcp.clickdeleteCustSubmit();
		logger.info("Submit clicked");

		Alert alert=driver.switchTo().alert();
		String alertMessage=driver.switchTo().alert().getText();
		logger.info(alertMessage);
		Thread.sleep(3000);
		alert.accept();
		Alert alert1=driver.switchTo().alert();
		String alertMessage1=driver.switchTo().alert().getText();

		if(exp.equals("pass"))
		{
						logger.info(alertMessage1);
			Thread.sleep(3000);
			if (alertMessage1.equalsIgnoreCase("Customer deleted Successfully"))
			{
				alert1.accept();
				Assert.assertTrue(true);
				logger.info("PASS");
			}
			else {
				alert1.accept();
				captureScreen(driver,"deleteCustomer");
				logger.info("FAIL");
				Assert.assertTrue(false);
			}
		}
		else if(exp.equals("fail"))
		{
			//				Alert alert2=driver.switchTo().alert();
			//				String alertMessage2=driver.switchTo().alert().getText();
			logger.info(alertMessage1);
			Thread.sleep(3000);
			if (alertMessage1.equalsIgnoreCase("Customer does not exist!!"))
			{
				alert1.accept();
				Assert.assertTrue(true);
				logger.info("PASS - incorrect ID");
			}
			else {
				alert1.accept();
				captureScreen(driver,"deleteCustomer");
				Assert.assertTrue(false);

				logger.info("FAIL");
			}
		}
	}
	public boolean isAlertPresent() //user defined method created to check alert is present or not
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}

	@DataProvider(name="DeleteCustomer")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/IntBanking/TestData/DeleteCustomer.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);

		String newcustomerdata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				newcustomerdata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
		}
		return newcustomerdata;
	}
}