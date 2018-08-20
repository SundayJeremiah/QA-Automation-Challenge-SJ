package Screens;

import org.openqa.selenium.By;

import globalDirectory.Global;
import globalDirectory.UtilityFunction;
import globalDirectory.ObjectRepository;

public class ProfilePage {

	//When user selects "Student / Staff"
	public static void clickOnStudentStaffProfile() throws InterruptedException
	{		
		UtilityFunction.waitForElementToLoadThenClickXpath(ObjectRepository.profileStudentStaff, Global.waitTimeMin);
	}
	
	//And clicks on "Accept" button
	public static void clickOnAcceptButton() throws InterruptedException
	{		
		UtilityFunction.waitForElementToLoadThenClickXpath(ObjectRepository.profileAcceptBtn, Global.waitTimeMin);
	}
	
}
