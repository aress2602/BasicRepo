package com.IntBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundTransferPage {
	WebDriver ldriver;

	public FundTransferPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//a[@href='FundTransInput.php']")
	WebElement lnkfundTransfer;

	@FindBy(xpath="//input[@name='payersaccount']")
	WebElement txtpayersAcc;
	
	@FindBy(xpath="//input[@name='payeeaccount']")
	WebElement txtpayeeAcc;
	
	@FindBy(xpath="//input[@name='ammount']")
	WebElement txtamount;
	
	@FindBy(xpath="//input[@name='desc']")
	WebElement txtdesc;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement btnFTSubmit;

	public void clickFindTransfer() 
	{
		lnkfundTransfer.click();
	}

	public void enterPayersAccount(String payersacc)
	{
		txtpayersAcc.sendKeys(payersacc);
	}
	
	public void enterPayeesAccount(String payeesacc)
	{
		txtpayeeAcc.sendKeys(payeesacc);
	}
	
	public void enterAmount(String ammt)
	{
		txtamount.sendKeys(ammt);
	}
	
	public void enterDesc(String descc)
	{
		txtdesc.sendKeys(descc);
	}
	
	public void clickFTSubmit()
	{
		btnFTSubmit.click();
	}
}
