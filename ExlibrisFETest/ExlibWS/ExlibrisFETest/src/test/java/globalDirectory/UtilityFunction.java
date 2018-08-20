package globalDirectory;

import java.util.Calendar;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class UtilityFunction {

	//This method checks for a CSS located element to load before clicking
	public static void waitForElementToLoadThenClick(String Element, int waitTimeMin) throws InterruptedException
	{
		int tryCount;
		for(tryCount = 1;tryCount<waitTimeMin;){
			try{
				if(Global.driver.findElement(By.cssSelector(Element)).isDisplayed()==true){
					break;
				}
			}
			catch(Exception E){
				{
					tryCount++;					
				}
			}
		}
		Global.driver.findElement(By.cssSelector(Element)).click();
		Thread.sleep(2000);
	}

	//This method checks for Xpath located element to load before clicking
	public static void waitForElementToLoadThenClickXpath(String Element, int waitTime) throws InterruptedException
	{
		int tryCount;
		for(tryCount = 1;tryCount<waitTime;){
			try{
				if(Global.driver.findElement(By.xpath(Element)).isDisplayed()==true){
					break;
				}
			}
			catch(Exception E){
				{
					tryCount++;					
				}
			}
		}
		Global.driver.findElement(By.xpath(Element)).click();		
	}


	public static void clickClearSendChar(String Element, String input) throws InterruptedException, Exception
	{
		waitForElementToLoadThenClick(Element, Global.waitTimeMin);
		String text_Value = Global.driver.findElement(By.cssSelector(Element)).getAttribute("value");
		if(text_Value!= null){
			Global.driver.findElement(By.cssSelector(Element)).clear();			
		}
		Global.driver.findElement(By.cssSelector(Element)).sendKeys(input);
	}	


	//Get The Current Day
	public static String getCurrentDay(){
		//Create a Calendar Object
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

		//Get Current Day as a number
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("Today Int: " + todayInt +"\n");

		//Integer to String Conversion
		String todayStr = Integer.toString(todayInt);
		System.out.println("Today Str: " + todayStr + "\n");

		return todayStr;
	}


	//This method selects and set dropdown option by value
	public static void selectDropDownValue(String dropDownElement, String dropDownOption){
		Select dropDown_List = new Select(Global.driver.findElement(By.cssSelector(dropDownElement)));
		dropDown_List.selectByValue(dropDownOption);
		
	}











}
