package com.IntBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomisedStatementPage 
{
	WebDriver ldriver;

	public CustomisedStatementPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//a[@href='CustomisedStatementInput.php']")
	WebElement lnkCustStmt;

	@FindBy(xpath="//input[@name='accountno']")
	WebElement txtAccountNo;

	@FindBy(xpath="//input[@name='fdate']")
	WebElement txtFromDate;

	@FindBy(xpath="//input[@name='tdate']")
	WebElement txtToDate;

	@FindBy(xpath="//input[@name='amountlowerlimit']")
	WebElement txtMinTransValue;

	@FindBy(xpath="//input[@name='numtransaction']")
	WebElement txtNoOfTrans;

	@FindBy(xpath="//input[@type='submit']")
	WebElement btnSubmit;

	public void clickCustomStmt() 
	{
		lnkCustStmt.click();
	}

	public void enterActNo(String acn)
	{
		txtAccountNo.sendKeys(acn);
	}

	public void setFromDate(String mm,String dd,String yy)
	{
		txtFromDate.sendKeys(mm);
		txtFromDate.sendKeys(dd);
		txtFromDate.sendKeys(yy);
	}
	
	public void setToDate(String mm,String dd,String yy)
	{
		txtToDate.sendKeys(mm);
		txtToDate.sendKeys(dd);
		txtToDate.sendKeys(yy);
	}

	public void enterMinTransValue(String mtv)
	{
		txtMinTransValue.sendKeys(mtv);
	}

	public void enterNoOfTransactions(String tn)
	{
		txtNoOfTrans.sendKeys(tn);
	}

	public void clickSubmit()
	{
		btnSubmit.click();
	}
}	
