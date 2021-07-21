package com.IntBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.IntBanking.PageObjects.LoginPage;
import com.IntBanking.PageObjects.NewAccountPage;
import com.IntBanking.Utilities.XLUtils;

public class TC_NewAccountDDT_05 extends BaseClass
{
	@Test(dataProvider="NewAccount")
	public void newAccountDDT(String user,String pwd,String customerid,String initdep,String exp) throws IOException, InterruptedException
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
		nap.enterAccountCustomerID(customerid);
		logger.info("customer ID entered");

		Select drpAcctType=new Select(driver.findElement(By.xpath("//select[@name='selaccount']")));
		drpAcctType.selectByValue("Current");

		nap.enterIntialDeposit(initdep);
		logger.info(initdep);

		nap.clickAddAccountSubmit();

		Thread.sleep(3000);
		logger.info("validation started....");

		if(exp.equals("pass"))
		{
			if(driver.getPageSource().contains("Account Generated Successfully!!!"))
			{
				WebDriverWait wait=new WebDriverWait(driver,2);
				WebElement cont=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='Managerhomepage.php']")));
				cont.click();
				lp.clickLogout();
				Thread.sleep(3000);
				driver.switchTo().alert().accept();//close logout alert
				driver.switchTo().defaultContent();
				Assert.assertTrue(true);
				logger.info("test case passed - 1");
			}
			else
			{
				logger.info("test case failed - 1");
				captureScreen(driver,"addAccount");
				Assert.assertTrue(false);
			}
		}
		else if(exp.equals("fail"))
		{
			if(isAlertPresent()==true)
			{
				driver.switchTo().alert().accept();
				Assert.assertTrue(true);
				logger.info("test case passed - 2");
			}
			else 
			{	
				logger.info("test case failed - 2");
				captureScreen(driver,"addAccount");
				Assert.assertTrue(false);
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

	@DataProvider(name="NewAccount")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/IntBanking/TestData/NewAccount.xlsx";
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