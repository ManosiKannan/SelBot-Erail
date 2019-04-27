package com.selbot.pages;

import org.hamcrest.Factory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selbot.testng.api.base.Annotations;

public class DuplicateLeadPage extends Annotations {

	public DuplicateLeadPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID, using="createLeadForm_companyName") WebElement eleCompanyName;
	@FindBy(how=How.CLASS_NAME, using="smallSubmit") WebElement eleclickLead;
	
	public DuplicateLeadPage enterCompanyName(String companyName)
	{	
		clearAndType(eleCompanyName, companyName);
		return this;
	}
	
	public ViewLeadPage clickCreateLead()
	{
	click(eleclickLead);
	return new ViewLeadPage();
	}
}
