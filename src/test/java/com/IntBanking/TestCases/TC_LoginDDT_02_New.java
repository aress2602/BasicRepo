package com.IntBanking.TestCases;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.IntBanking.PageObjects.LoginPage;
import com.IntBanking.Utilities.XLUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;

public class TC_LoginDDT_02_New extends BaseClass 
{

	@Test(dataProvider="LoginData2")
	public void loginDDT2(String user,String pwd,String result) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(1000);

		if(result.equals("pass"))
		{
			if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
			{
				Assert.assertTrue(true);
				logger.info("Login passed");
				lp.clickLogout();
				Thread.sleep(3000);
				driver.switchTo().alert().accept();//close logout alert
				driver.switchTo().defaultContent();
			}
			else
			{
				Assert.assertTrue(false);
				logger.info("Login failed, even when credentials are valid");
			}
		}
		else if(result.equals("fail"))
		{
			if(isAlertPresent()==true)
			{
				driver.switchTo().alert().accept();//close alert
				driver.switchTo().defaultContent();
				Assert.assertTrue(true);
				logger.info("Login failed");
			}
			else
			{
				Assert.assertTrue(false);
				logger.warn("Login success, even if credentials are invalid");
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
	@DataProvider(name="LoginData2")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/IntBanking/TestData/LoginData2.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}

		}
		return logindata;
	}
}