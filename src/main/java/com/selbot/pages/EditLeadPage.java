package com.selbot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selbot.testng.api.base.Annotations;

public class EditLeadPage extends Annotations {
	
	public EditLeadPage()
	{
		PageFactory.initElements(driver, this);
	}
@FindBy(how=How.ID, using="updateLeadForm_companyName") WebElement eleCompanyName;
@FindBy(how=How.ID, using="updateLeadForm_departmentName") WebElement eleDepartName;
@FindBy(how=How.XPATH, using="//input[@value='Update']") WebElement eleUpdateBtn;

public EditLeadPage enterCompanyName(String companyName)
{
	clearAndType(eleCompanyName, companyName);
	return this;
}
public EditLeadPage enterDepartmentName(String departName)
{
	clearAndType(eleDepartName, departName);
	return this;
}
public ViewLeadPage clickUpdateButton()
{
	click(eleUpdateBtn);
	return new ViewLeadPage();
}


}
