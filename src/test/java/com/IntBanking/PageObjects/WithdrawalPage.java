package com.IntBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WithdrawalPage {
	WebDriver ldriver;

	public WithdrawalPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//a[@href='WithdrawalInput.php']")
	WebElement lnkWithdrawal;

	@FindBy(xpath="//input[@name='accountno']")
	WebElement txtAccNumber;
	
	@FindBy(xpath="//input[@name='ammount']")
	WebElement txtAmount;
	
	@FindBy(xpath="//input[@name='desc']")
	WebElement txtDesc;

	@FindBy(xpath="//input[@type='submit']")
	WebElement btnWithdrawalSubmit;

	public void clickWithdrawal() 
	{
		lnkWithdrawal.click();
	}

	public void enterAccountNumber(String acno)
	{
		txtAccNumber.sendKeys(acno);
	}
	
	public void enterAmount(String amt)
	{
		txtAmount.sendKeys(amt);
	}
	
	public void enterDescription(String desc)
	{
		txtDesc.sendKeys(desc);
	}
	
	public void clickWithdrawalSubmit()
	{
		btnWithdrawalSubmit.click();
	}
}
