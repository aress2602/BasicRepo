package com.IntBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAccountPage
{
	WebDriver ldriver;

	public NewAccountPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//a[@href='addAccount.php']")
	WebElement lnkAddAccount;

	@FindBy(xpath="//input[@name='cusid']")
	WebElement txtacctCustID;

	@FindBy(xpath="//input[@name='inideposit']")
	WebElement txtinitalDeposit;

	@FindBy(xpath="//input[@name='button2']")
	WebElement btnaddAccount;

	public void clickAddAccount() 
	{
		lnkAddAccount.click();
	}

	public void enterAccountCustomerID(String acid)
	{
		txtacctCustID.sendKeys(acid);
	}

	public void enterIntialDeposit(String initdep)
	{
		txtinitalDeposit.sendKeys(initdep);
	}

	public void clickAddAccountSubmit()
	{
		btnaddAccount.click();
	}
}