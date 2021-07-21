package com.IntBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccountPage 
{
	WebDriver ldriver;

	public EditAccountPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//a[@href='editAccount.php']")
	WebElement lnkEditAccount;

	@FindBy(xpath="//input[@name='accountno']")
	WebElement txtacctno;

	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement btneditAccount;

	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement btneditAccountSave;

	public void clickEditAccount() 
	{
		lnkEditAccount.click();
	}

	public void enterAccountNo(String accno)
	{
		txtacctno.sendKeys(accno);
	}

	public void clickEditAccountSubmit()
	{
		btneditAccount.click();
	}

	public void clickEditAccountSave()
	{
		btneditAccountSave.click();
	}
}