package com.IntBanking.TestCases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.IntBanking.PageObjects.LoginPage;
import com.IntBanking.PageObjects.NewCustomerPage;
import com.IntBanking.Utilities.XLUtils;

public class TC_NewCustomerDDT_01 extends BaseClass
{
	@Test(dataProvider="NewCustomer")
	public void newCustomerDDT(String user,String pwd,String dob,String address,String city,String state,String pin,String mob,String password1,String exp) throws InterruptedException, IOException
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

		NewCustomerPage ncp=new NewCustomerPage(driver);

		ncp.clickAddNewCustomer();

		String name="Customer "+randomestring();
		ncp.enterCustomerName(name);
		logger.info(name);

		ncp.selectGender();
		//		ncp.setDOB("10-","15-","1985");
		WebDriverWait wait2=new WebDriverWait(driver,5);
		WebElement txtdob=wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='dob']")));
		txtdob.sendKeys(dob);
		logger.info(dob);
		Thread.sleep(3000);
		ncp.enterAddress(address);
		ncp.enterCity(city);
		ncp.enterState(state);
		ncp.enterPIN(pin);
		ncp.enterMobNo(mob);

		String email=randomestring()+"@gmail.com";
		ncp.enterEmail(email);

		ncp.enterPassword(password1);
		ncp.clickSubmit();

		Thread.sleep(3000);
		logger.info("validation started....");

		if(exp.equals("pass"))
		{
			if(driver.getPageSource().contains("Customer Registered Successfully!!!"))
			{
				WebDriverWait wait=new WebDriverWait(driver,5);
				WebElement cont=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='Managerhomepage.php']")));
				cont.click();
				WebDriverWait wait1=new WebDriverWait(driver,5);
				WebElement logout=wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='Logout.php']")));
				logout.click();
				Thread.sleep(3000);
				driver.switchTo().alert().accept();//close logout alert
				driver.switchTo().defaultContent();
				Assert.assertTrue(true);
				logger.info("test case passed....");
			}
			else
			{
				Assert.assertTrue(false);
				logger.info("Login failed, even when credentials are valid");
			}
		}
		else if(exp.equals("fail"))
		{
			if (isAlertPresent()==true)
			{
				driver.switchTo().alert().accept();//close alert
				driver.switchTo().defaultContent();
				WebDriverWait wait=new WebDriverWait(driver,5);
				WebElement home=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/p/a")));
				home.click();
				Thread.sleep(3000);
				lp.clickLogout();
				driver.switchTo().alert().accept();//close logout alert
				driver.switchTo().defaultContent();
				Assert.assertTrue(true);
				logger.info("Issue submitting the form");
			}
			else
			{
				Assert.assertTrue(false);
				logger.warn("Form submitted, without all fields filled");
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
	private String randomestring() {
		// TODO Auto-generated method stub
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return(generatedstring);
	}
	@DataProvider(name="NewCustomer")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/IntBanking/TestData/NewCustomer.xlsx";
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