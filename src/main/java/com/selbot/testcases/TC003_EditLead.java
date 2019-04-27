package com.selbot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selbot.pages.LoginPage;
import com.selbot.testng.api.base.Annotations;

public class TC003_EditLead extends Annotations {
	@BeforeTest
	public void setData() {
		testcaseName = "TC003_EditLead";
		testcaseDec = "Login, Edit Lead and Verify";
		author = "Manu";
		category = "smoke";
		excelFileName = "TC003";
	}
	
	@Test(dataProvider="fetchData")
	public void editLead(String uName, String pwd, String firstName, String companyName, String departName)
	{
		new LoginPage()
		.enterUserName(uName)
		.enterPassWord(pwd) 
		.clickLogin()
		.clickCRMSFA()
		.clickLeads()
		.clickFindLead()
		.enterFirstName(firstName)
		.clickFindLeads()
		.clickFirstLead()
		.clickEdit()
		.enterCompanyName(companyName)
		.enterDepartmentName(departName)
		.clickUpdateButton()
		.verifyEditPageDetails(companyName, departName);
		
	}
}
