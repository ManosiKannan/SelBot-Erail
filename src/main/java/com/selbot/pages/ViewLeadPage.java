package com.selbot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selbot.testng.api.base.Annotations;

import net.bytebuddy.description.modifier.SynchronizationState;

public class ViewLeadPage extends Annotations{
	
	public ViewLeadPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID, using="viewLead_companyName_sp")  WebElement eleCompanyName;
	@FindBy(how=How.LINK_TEXT, using="Duplicate Lead") WebElement eleDuplicateLink;
	@FindBy(how=How.LINK_TEXT, using="Edit") WebElement eleEditLink;
	@FindBy(how=How.ID, using="viewLead_departmentName_sp") WebElement eleDepartmentName;
	@FindBy(how=How.LINK_TEXT, using="Delete") WebElement eleDeleteLink;

	public String company_Name =" "; 
	public String depart_Name =" ";
	
	public ViewLeadPage verifyCompanyName(String data) {
		company_Name=getElementText(eleCompanyName);
		System.out.println(company_Name);
		if (company_Name.contains(data)) {
			System.out.println("The Company Name is Matching Successfully ");
		} else {
			System.out.println("The Company Name is not Matching ");
		}
		return this;
	}
	
	public DuplicateLeadPage clickDuplicateLead()
	{
		click(eleDuplicateLink);
		return new DuplicateLeadPage();
	}
	
	public EditLeadPage clickEdit()
	{
		click(eleEditLink);
		return new EditLeadPage();
	}
	
	public ViewLeadPage verifyEditPageDetails(String companyName, String departName)
	{
		depart_Name=getElementText(eleDepartmentName);
		company_Name=getElementText(eleCompanyName);
		if(company_Name.contains(companyName) && depart_Name.contains(departName))
		{
			System.out.println("Edited Company and Department names are displayed");
		}
		else
			System.out.println("Company and Department names are not edited");
		return this;
	}
	
	public MyLeadPage clickDeleteLink()
	{
		click(eleDeleteLink);
		return new MyLeadPage();
	}






}
