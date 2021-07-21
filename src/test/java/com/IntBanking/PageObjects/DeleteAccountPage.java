package com.IntBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountPage {
	WebDriver ldriver;

	public DeleteAccountPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		}
	
	@FindBy(xpath="//a[@href='deleteAccountInput.php']")
	WebElement lnkDeleteAccount;
	
	@FindBy(xpath="//input[@name='accountno']")
	WebElement txtdAccNo;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement btnDeleteAccountSubmit;

	public void clickDeleteAccount() 
	{
		lnkDeleteAccount.click();
		}
	
	public void enterdAccountNo(String dacctno)
	{
		txtdAccNo.sendKeys(dacctno);
	}
	
	public void clickdeleteAccountSubmit()
	{
		btnDeleteAccountSubmit.click();
	}
}
