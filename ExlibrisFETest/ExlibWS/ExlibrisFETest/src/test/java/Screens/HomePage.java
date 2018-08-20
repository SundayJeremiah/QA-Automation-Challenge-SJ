package Screens;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import globalDirectory.Global;
import globalDirectory.ObjectRepository;
import globalDirectory.UtilityFunction;

public class HomePage {

	
	//Then verify user is logged in
	public static void verificationOfUserLoggedIn() throws InterruptedException, Exception
	{
		boolean userLogged_In = Global.driver.findElement(By.cssSelector(ObjectRepository.HomePageLoggedin)).isDisplayed();		
		Assert.assertTrue(userLogged_In);		
	}
	
	//And user closes the tile (Use different way to close than used before), click on Angle down button on the top right of the page and click on "Log Out"
	public static void returnToHomePage() throws InterruptedException, Exception
	{
		Global.driver.switchTo().defaultContent();		
		UtilityFunction.waitForElementToLoadThenClick(ObjectRepository.tileClose, Global.waitTimeMin);	
		UtilityFunction.waitForElementToLoadThenClick(ObjectRepository.homeMenuAngleDown, Global.waitTimeMin);
		UtilityFunction.waitForElementToLoadThenClickXpath(ObjectRepository.logOut, Global.waitTimeMin);		
	}
	
	//Then verify user has logged out
	public static void logOutHomePage() throws InterruptedException, Exception
	{
		WebDriverWait wait = new WebDriverWait(Global.driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(ObjectRepository.profilecampusM)));
		UtilityFunction.waitForElementToLoadThenClick(ObjectRepository.profilecampusM, Global.waitTimeMin);		
		boolean campusMHomePage = Global.driver.findElement(By.cssSelector(ObjectRepository.profilecampusM)).isDisplayed();
		Assert.assertTrue(campusMHomePage);		
	}
	
	
	
	
}
