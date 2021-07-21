package com.IntBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BalanceEnquiryPage {
	WebDriver ldriver;

	public BalanceEnquiryPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//a[@href='BalEnqInput.php']")
	WebElement lnkbalEnquiry;

	@FindBy(xpath="//input[@name='accountno']")
	WebElement txtaccountNo;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement btnSubmit;

	public void clickBalEnquiry()
	{
		lnkbalEnquiry.click();
	}

	public void enterAccountNo(String acc)
	{
		txtaccountNo.sendKeys(acc);
	}
	
	public void clickBalEnquirySubmit()
	{
		btnSubmit.click();
	}
}
