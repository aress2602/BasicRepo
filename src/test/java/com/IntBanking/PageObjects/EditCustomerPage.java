package com.IntBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage 
{
	WebDriver ldriver;

	public EditCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		}
	
	@FindBy(xpath="//a[@href='EditCustomer.php']")
	WebElement lnkEditCustomer;
	
	@FindBy(xpath="//input[@name='cusid']")
	WebElement txtCustID;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement btnCustomerIDSubmit;
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement txteAddress;

	@FindBy(xpath="//input[@name='city']")
	WebElement txteCity;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement txteState;
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement txtePIN;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement txteMob;
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement txteEmail;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btneSubmit;

	
	public void clickEditCustomer() 
	{
		lnkEditCustomer.click();
		}
	
	public void enterCustomerID(String cid)
	{
		txtCustID.sendKeys(cid);
	}
	
	public void clickCIDSubmit()
	{
		btnCustomerIDSubmit.click();
	}
	
	public void enterAddress(String caddress)
	{
		txteAddress.clear();
		txteAddress.sendKeys(caddress);
	}

	public void enterCity(String ccity)
	{
		txteCity.clear();
		txteCity.sendKeys(ccity);
	}

	public void enterState(String cstate)
	{
		txteState.clear();
		txteState.sendKeys(cstate);
	}
	
	public void enterPIN(String cpin)
	{
		txtePIN.clear();
		txtePIN.sendKeys(cpin);
	}
	
	public void enterMobNo(String cmobno)
	{
		txteMob.clear();
		txteMob.sendKeys(cmobno);
	}
	
	public void enterEmail(String cemail)
	{
		txteEmail.clear();
		txteEmail.sendKeys(cemail);
	}
	
	public void clickEditCustomerSubmit()
	{
		btneSubmit.click();
	}
}
