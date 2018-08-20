package Screens;

import org.junit.Assert;
import org.openqa.selenium.By;

import globalDirectory.Global;
import globalDirectory.ObjectRepository;
import globalDirectory.UtilityFunction;

public class LoginPage {
	
	
	public static void inputLoginDetails(String userName, String password) throws InterruptedException, Exception
	{		
		String[] parts_Name = userName.split(",");
		String[] parts_Word = password.split(",");	
		UtilityFunction.clickClearSendChar(ObjectRepository.profileUserName, parts_Name[0]);
		UtilityFunction.clickClearSendChar(ObjectRepository.profileUserPassword, parts_Word[0]);
	}
	
	//Then user should verify "Login" button is displayed and clicks it
	public static void verifyLoginButtonDisplayedAndClick(String loginBtn) throws InterruptedException, Exception
	{
		boolean loginEle = Global.driver.findElement(By.cssSelector(ObjectRepository.profileLogin)).isDisplayed();
		Assert.assertTrue(loginEle);
		
		UtilityFunction.waitForElementToLoadThenClick(ObjectRepository.profileLogin, Global.waitTimeMin);
	}
	
	//And user should also verify error message displayed is "Please try again."
	public static void verifyOfErrorMessage(String errorMsg) throws InterruptedException, Exception
	{
		String Error_MSG = Global.driver.findElement(By.cssSelector(ObjectRepository.profileLoginErrorMSG)).getText();
		Assert.assertEquals(errorMsg, Error_MSG);
	}
	
	//When user enter the values for "<Username>" and "<Password>" and clicks on "Login" button
	public static void inputValidLoginDetails(String userName, String password, String login) throws InterruptedException, Exception
	{		
		String[] parts_Name = userName.split(",");
		String[] parts_Word = password.split(",");	
		UtilityFunction.clickClearSendChar(ObjectRepository.profileUserName, parts_Name[1]);
		UtilityFunction.clickClearSendChar(ObjectRepository.profileUserPassword, parts_Word[1]);
		UtilityFunction.waitForElementToLoadThenClick(ObjectRepository.profileLogin, Global.waitTimeMin);
	}
	

	
	
	
	
	
	
	
	
	

}
