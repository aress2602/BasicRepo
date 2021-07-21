package com.IntBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage 
{
	WebDriver ldriver;

	public NewCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//a[text()='New Customer']")
	WebElement lnkAddNewCustomer;

	@FindBy(xpath="//input[@name='name']")
	WebElement txtCustomerName;

	@FindBy(xpath="//input[@value='f']")
	WebElement rdGender;

	@FindBy(xpath="//input[@id='dob']")
	WebElement txtDOB;

	@FindBy(xpath="//textarea[@name='addr']")
	WebElement txtAddress;

	@FindBy(xpath="//input[@name='city']")
	WebElement txtCity;

	@FindBy(xpath="//input[@name='state']")
	WebElement txtState;

	@FindBy(xpath="//input[@name='pinno']")
	WebElement txtPIN;

	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement txtMob;

	@FindBy(xpath="//input[@name='emailid']")
	WebElement txtEmail;

	@FindBy(xpath="//input[@name='password']")
	WebElement txtPassword1;

	@FindBy(xpath="//input[@type='submit']")
	WebElement btnSubmit;

//	@FindBy(xpath="//table/tbody/tr[4]/td[2]")
//	WebElement txtuniqueID;

	public void clickAddNewCustomer() 
	{
		lnkAddNewCustomer.click();
	}

	public void enterCustomerName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}

	public void selectGender()
	{
		rdGender.click();
	}

	public void setDOB(String mm,String dd,String yy)
	{
		txtDOB.sendKeys(mm);
		txtDOB.sendKeys(dd);
		txtDOB.sendKeys(yy);
	}

	public void enterAddress(String caddress)
	{
		txtAddress.sendKeys(caddress);
	}

	public void enterCity(String ccity)
	{
		txtCity.sendKeys(ccity);
	}

	public void enterState(String cstate)
	{
		txtState.sendKeys(cstate);
	}

	public void enterPIN(String cpin)
	{
		txtPIN.sendKeys(cpin);
	}

	public void enterMobNo(String cmobno)
	{
		txtMob.sendKeys(cmobno);
	}

	public void enterEmail(String cemail)
	{
		txtEmail.sendKeys(cemail);
	}

	public void enterPassword(String cpassword)
	{
		txtPassword1.sendKeys(cpassword);
	}

	public void clickSubmit()
	{
		btnSubmit.click();
	}
}	
