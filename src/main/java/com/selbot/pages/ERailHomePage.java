package com.selbot.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selbot.testng.api.base.Annotations;

public class ERailHomePage extends Annotations {
	public ERailHomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "txtStationFrom")
	WebElement eleFromStation;
	@FindBy(how = How.ID, using = "txtStationTo")
	WebElement eleToStation;
	@FindBy(how = How.ID, using = "chkSelectDateOnly")
	WebElement eleCheckDateOnly;
	@FindBy(how = How.XPATH, using = "//table[@class='DataTable TrainList']")
	WebElement eleTrainListTable;

	public ERailHomePage enterFromStation(String fromStation) {
		clearAndType(eleFromStation, fromStation);
		sendKeysWithOnlyKeys(eleFromStation, Keys.TAB);
		return this;
	}

	public ERailHomePage enterToStation(String toStation) {
		clearAndType(eleToStation, toStation);
		sendKeysWithOnlyKeys(eleToStation, Keys.TAB);
		return this;
	}

	public ERailHomePage clickTrainOnDate() throws InterruptedException {
				
		if (verifySelected(eleCheckDateOnly)) {
			click(eleCheckDateOnly);
		}
		Thread.sleep(2000);
		return this;
	}

	public ERailHomePage getTrainNames(String trainName) {
		List<WebElement> rows = eleTrainListTable.findElements(By.tagName("tr"));
		List<String> seatList = new ArrayList<String>();
		int rowSize = rows.size();
		for (int i = 0; i < rowSize; i++) {
			WebElement row = rows.get(i);
			List<WebElement> columns = row.findElements(By.tagName("td"));
			String trainNames = columns.get(1).getText();
			if (trainNames.equals(trainName)) {
				int columnSize = columns.size();

				for (int j = 15; j <columnSize; j++) {
					seatList.add(columns.get(j).getText());
				}
			}
		}
		System.out.println("Available no of 1A seat is :"+seatList.get(0));
		System.out.println("Available no of 2A seat is :"+seatList.get(1));
		System.out.println("Available no of 3A seat is :"+seatList.get(2));
		System.out.println("Available no of CC seat is :"+seatList.get(3));
		System.out.println("Available no of SL seat is :"+seatList.get(4));
		System.out.println("Available no of 2S seat is :"+seatList.get(5));
		System.out.println("Available no of EA seat is :"+seatList.get(6));
		System.out.println("Available no of EC seat is :"+seatList.get(7));
		
		return this;

	}
}
