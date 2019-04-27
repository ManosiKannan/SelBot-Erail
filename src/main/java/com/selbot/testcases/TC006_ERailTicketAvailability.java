package com.selbot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selbot.pages.ERailHomePage;
import com.selbot.testng.api.base.Annotations;

public class TC006_ERailTicketAvailability extends Annotations
{
	@BeforeTest
	public void setData() {
		testcaseName = "TC006_ERailTicketAVailability";
		testcaseDec = "Login, Check the ticket availability";
		author = "Mano";
		category = "smoke";
		excelFileName = "TC006";
	}
	@Test(dataProvider="fetchData") 
 public void getTicketAvailability(String fromStation, String toStation, String trainName) throws InterruptedException
 {
	 new ERailHomePage().enterFromStation(fromStation).enterToStation(toStation).clickTrainOnDate().getTrainNames(trainName);
 }
}
