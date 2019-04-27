package com.selbot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selbot.pages.LoginPage;
import com.selbot.testng.api.base.Annotations;

public class TC004_DeleteLead extends Annotations {
	@BeforeTest
	public void setData() {
		testcaseName = "TC004_DeleteLead";
		testcaseDec = "Login, Delete Lead and Verify";
		author = "Manu";
		category = "smoke";
		excelFileName = "TC004";
	} 

	@Test(dataProvider="fetchData") 
	public void deleteLead(String uName, String pwd, String leadID) {
		new LoginPage()
		.enterUserName(uName)
		.enterPassWord(pwd) 
		.clickLogin()
		.clickCRMSFA()
		.clickLeads()
		.clickFindLead()
		.enterLeadID(leadID)
		.clickFindLeads()
		.clickFirstLead()
		.clickDeleteLink()
		.clickFindLead()
		.enterLeadID(leadID)
		.clickFindLeads()
		.verifyDeleteLead();
	}

}
