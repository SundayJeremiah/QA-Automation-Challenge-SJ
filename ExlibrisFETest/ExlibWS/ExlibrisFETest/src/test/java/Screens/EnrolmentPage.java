package Screens;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import globalDirectory.Global;
import globalDirectory.ObjectRepository;
import globalDirectory.UtilityFunction;

public class EnrolmentPage {

	public static String storedValue_DateFieldValue = null;

	//When user clicks on tile, Enrolment -> Your Details -> Personal Details
	public static void clicksOnEnrollmentYourDetailsAndPersonalDetails() throws InterruptedException, Exception
	{		
		UtilityFunction.waitForElementToLoadThenClickXpath(ObjectRepository.enrollmentlabel, Global.waitTimeMin);
		Global.driver.switchTo().frame(ObjectRepository.enrollmentPageSwitch);
		UtilityFunction.waitForElementToLoadThenClick(ObjectRepository.enrollmentYourDetails, Global.waitTimeMin);
		UtilityFunction.waitForElementToLoadThenClick(ObjectRepository.enrollmentPersonalDetails, Global.waitTimeMin);
	}
	
	//And user gets the value from the 'Date of Birth' field and change the current values to "<Date_of_Birth>"
	public static void settingOfNewDate(String dOB) throws InterruptedException, Exception
	{
		String dateFieldValue = Global.driver.findElement(By.id(ObjectRepository.enrollmentDateOfBirth)).getAttribute("value");
		storedValue_DateFieldValue = dateFieldValue;
		
		String[] parts = dOB.split("/");
		Global.driver.findElement(By.id(ObjectRepository.enrollmentDateOfBirth)).sendKeys(parts[0]);
		Global.driver.findElement(By.id(ObjectRepository.enrollmentDateOfBirth)).sendKeys(parts[1]);
		Global.driver.findElement(By.id(ObjectRepository.enrollmentDateOfBirth)).sendKeys(parts[2]);
		UtilityFunction.waitForElementToLoadThenClickXpath(ObjectRepository.enrollmentPersonalDetailsPageT, Global.waitTimeMin);
	}
	//returning datefield value
	public static String returnstoredValue_DateFieldValue() throws Exception
	{
		return storedValue_DateFieldValue;		
	}
	
	//And user adds "<First_Name>" and "<Last_Name>" values "Parent's / Guardian's Name" section
	public static void addFirstNameAndLastNameOnParentsSection(String firstName, String lastName) throws InterruptedException, Exception
	{		
		String[] partsFirstName = firstName.split(",");
		String[] partsLastName = lastName.split(",");

		UtilityFunction.clickClearSendChar(ObjectRepository.enrollmentFirstName, partsFirstName[0]);
		UtilityFunction.clickClearSendChar(ObjectRepository.enrollmentLastName, partsLastName[0]);		
	}
	
	//And adds "<Email_Address>" under Contact Information section and selects "<Gender_Type>" value in Gender section, now close the tile
	public static void addEmailAndSelectGenderType(String emailAddress, String genderType) throws InterruptedException, Exception
	{
		String[] partsEmailAddress = emailAddress.split(",");
		String[] partsgenderType = genderType.split(",");

		UtilityFunction.clickClearSendChar(ObjectRepository.enrollmentEmailAddress, partsEmailAddress[0]);
		UtilityFunction.selectDropDownValue(ObjectRepository.enrollmentGender, partsgenderType[0]);
		
		//Switch back to default driver handle
		Global.driver.switchTo().defaultContent();		
		UtilityFunction.waitForElementToLoadThenClick(ObjectRepository.tileClose, Global.waitTimeMin);		
	}
	
	//Then user verifies Date of Birth as "<DOB>", Parent’s/Guardian’s First Name as "<First_Name>", Last Name as "<Last_Name>", Gender as "<Gender_Type>" Email Address as "<Email_Address>"
	public static void verify_DOB_First_Name_Last_Name_Gender_Type(String dOB, String firstName, String lastName, String genderType, String emailAddress) throws InterruptedException, Exception
	{
		String[] partsDOB = dOB.split(",");
		String[] partsFirstName = firstName.split(",");
		String[] partsLastName = lastName.split(",");
		String[] partsGenderType = genderType.split(",");
		String[] partsEmailAddress = emailAddress.split(",");

		
		String dOB_Value = Global.driver.findElement(By.id(ObjectRepository.enrollmentDateOfBirth)).getAttribute("value");
		String newdOB_Value = dOB_Value.replaceAll("-", "/");		
		String[] parts = newdOB_Value.split("/");
		String newDOB_Value = parts[2] + "/" + parts[1] + "/" + parts[0];		
		Assert.assertEquals(partsDOB[0], newDOB_Value);		
		
		String firstName_Value = Global.driver.findElement(By.cssSelector(ObjectRepository.enrollmentFirstName)).getAttribute("value");
		Assert.assertEquals(partsFirstName[0], firstName_Value);
		
		String lastName_Value = Global.driver.findElement(By.cssSelector(ObjectRepository.enrollmentLastName)).getAttribute("value");
		Assert.assertEquals(partsLastName[0], lastName_Value);
		
		String gender_Value = Global.driver.findElement(By.cssSelector(ObjectRepository.enrollmentGender)).getAttribute("value");
		Assert.assertEquals(partsGenderType[0], gender_Value);

		String emailAddress_Value = Global.driver.findElement(By.cssSelector(ObjectRepository.enrollmentEmailAddress)).getAttribute("value");
		Assert.assertEquals(partsEmailAddress[0], emailAddress_Value);
	}
	
	//When user again reverses Date of Birth field "<DOB>" to defualt, "<First_Name>", "<Last_Name>", "<Email_Address>" all blanks and Gender to be "<Gender_Type>"
	public static void update_DOB_First_Name_Last_Name_Email_Address_Gender_Type(String dOB, String firstName, String lastName, String emailAddress, String genderType) throws InterruptedException, Exception
	{
		String dobStoreReturn = returnstoredValue_DateFieldValue();
		String[] parts = dobStoreReturn.split("-");		
		
		Global.driver.findElement(By.id(ObjectRepository.enrollmentDateOfBirth)).sendKeys(parts[2]);
		Global.driver.findElement(By.id(ObjectRepository.enrollmentDateOfBirth)).sendKeys(parts[1]);
		Global.driver.findElement(By.id(ObjectRepository.enrollmentDateOfBirth)).sendKeys(parts[0]);
		
		
		String[] partsFirstName = firstName.split(",");
		String[] partsLastName = lastName.split(",");
		
		if(partsFirstName[1].equals(partsFirstName[1])){
			WebElement firstName_Ele = Global.driver.findElement(By.cssSelector(ObjectRepository.enrollmentFirstName));
			firstName_Ele.sendKeys(Keys.CONTROL, "a");
			firstName_Ele.sendKeys(Keys.DELETE);
		}		
		
		if(partsLastName[1].equals(partsLastName[1])){
			WebElement lastName_Ele = Global.driver.findElement(By.cssSelector(ObjectRepository.enrollmentLastName));
			lastName_Ele.sendKeys(Keys.CONTROL, "a");
			lastName_Ele.sendKeys(Keys.DELETE);
		}
		
		String[] partsEmailAddress = emailAddress.split(",");
		String[] partsgenderType = genderType.split(",");

		if(partsEmailAddress[1].equals(partsEmailAddress[1])){
			WebElement Email_Ele = Global.driver.findElement(By.cssSelector(ObjectRepository.enrollmentEmailAddress));
			Email_Ele.sendKeys(Keys.CONTROL, "a");
			Email_Ele.sendKeys(Keys.DELETE);
		}
		UtilityFunction.selectDropDownValue(ObjectRepository.enrollmentGender, partsgenderType[1]);			
	}
	
	
	
	
}
