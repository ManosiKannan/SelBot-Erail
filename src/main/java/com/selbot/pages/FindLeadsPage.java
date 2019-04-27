package com.selbot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selbot.testng.api.base.Annotations;

public class FindLeadsPage extends Annotations {

	public FindLeadsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.LINK_TEXT, using="Email") WebElement eleEmailLink;
	@FindBy(how=How.NAME, using="emailAddress") WebElement eleEmailAddress;
	@FindBy(how=How.XPATH, using="//span[text()='Lead List']/following::a[@class='linktext'][1]") WebElement eleFirstLead;
	@FindBy(how=How.XPATH, using="(//button[@class='x-btn-text'])[7]") WebElement eleFindLeads; 
	
	@FindBy(how=How.XPATH, using="(//input[@name='firstName'])[3]") WebElement eleFirstName;
	@FindBy(how=How.NAME, using="id") WebElement eleLeadID;
	@FindBy(how=How.XPATH, using="//div[@class='x-paging-info']") WebElement eleLeadResult;
	
	public String result=" ";
	public FindLeadsPage clickEmailTab()
	{
		click(eleEmailLink);
		return this;
	}
	
	public FindLeadsPage enterEmailAddr(String email)
	{
		clearAndType(eleEmailAddress, email);
		return this;
	}
	
	
	public FindLeadsPage enterFirstName(String firstName)
	{
		clearAndType(eleFirstName, firstName);
		return this;
	}
	
	public FindLeadsPage enterLeadID(String leadID)
	{
		clearAndType(eleLeadID, leadID);
		return this;
	}
	public FindLeadsPage clickFindLeads()
	{
		click(eleFindLeads);
		return this;
	}
	
	public ViewLeadPage clickFirstLead()
	{
		click(eleFirstLead);
		return new ViewLeadPage();
	}
	
	public FindLeadsPage verifyDeleteLead()
	{
		result=getElementText(eleLeadResult);
		
		if(result.equals("No records to display"))
		{
			System.out.println("Lead was deleted successfully");
		}
		else
			System.out.println("Deleted lead was unsuccessful");
		return this;
	}
	
}

