package com.IntBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage 
{
	WebDriver ldriver;

	public DeleteCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		}
	
	@FindBy(xpath="//a[@href='DeleteCustomerInput.php']")
	WebElement lnkDeleteCustomer;
	
	@FindBy(xpath="//input[@name='cusid']")
	WebElement txtdCustID;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement btnDeleteCustSubmit;

	public void clickDeleteCustomer() 
	{
		lnkDeleteCustomer.click();
		}
	
	public void enterdCustomerID(String cdid)
	{
		txtdCustID.sendKeys(cdid);
	}
	
	public void clickdeleteCustSubmit()
	{
		btnDeleteCustSubmit.click();
	}
}
