package com.ExlibrisFETestProject.ExlibrisFETest;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import globalDirectory.Global;
import globalDirectory.UtilityFunction;
import Screens.HomePage;
import Screens.LoginPage;
import Screens.ProfilePage;
import Screens.EnrolmentPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinition {

	//WebDriver driver = null;
	DesiredCapabilities caps = new DesiredCapabilities();
	
	@Before
	public void Setup() throws Exception 
	{
		System.out.println("Chrome browser is yet to start");
		String exePath = "C:\\WS\\ExlibWS\\ExlibrisFETest\\src\\chromedriver.exe";
		//File file = new File("src");		
		caps.setCapability(ChromeOptions.CAPABILITY, exePath);
		caps.setCapability(ChromeOptions.CAPABILITY, true);
		
		System.setProperty("webdriver.chrome.driver", exePath);
		Global.driver = new ChromeDriver();	
		Global.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Global.driver.manage().window().maximize();		
		Thread.sleep(8000);
	}
	
	@After
	public void ShutDownBrowser() throws Throwable,Throwable  
	{
		Global.driver.quit();		
	}
	
	//Given user navigates to campusm site "<URL>"
	@Given("^user navigates to campusm site \"([^\"]*)\"$")
	public void user_navigates_to_campusm_site(String URL) throws Throwable 
	{
		Global.driver.navigate().to(URL);
	}	
	
	//When user selects "Student / Staff"
	@When("^user selects \"([^\"]*)\"$")
	public void user_selects(String arg1) throws Throwable 
	{
		ProfilePage.clickOnStudentStaffProfile();
	}
	
	//And clicks on "Accept" button
	@And("^clicks on \"([^\"]*)\" button$")
	public void clicks_on_button(String arg1) throws Throwable 
	{
		ProfilePage.clickOnAcceptButton();
	}

	//And enters the values for "<Username>" and "<Password>"
	@And("^enters the values for \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enters_the_values_for_and(String userName, String password) throws Throwable 
	{
		LoginPage.inputLoginDetails(userName, password);
	}

	//Then user should verify "Login" button is displayed and clicks it
	@Then("^user should verify \"([^\"]*)\" button is displayed and clicks it$")
	public void user_should_verify_button_is_displayed_and_clicks_it(String loginBtn) throws Throwable 
	{
		LoginPage.verifyLoginButtonDisplayedAndClick(loginBtn);
	}

	//And user should also verify error message displayed is "Please try again."
	@And("^user should also verify error message displayed is \"([^\"]*)\"$")
	public void user_should_also_verify_error_message_displayed_is(String errorMsg) throws Throwable 
	{
		LoginPage.verifyOfErrorMessage(errorMsg);
	}
	
	//When user enter the values for "<Username>" and "<Password>" and clicks on "Login" button
	@When("^user enter the values for \"([^\"]*)\" and \"([^\"]*)\" and clicks on \"([^\"]*)\" button$")
	public void user_enter_the_values_for_and_and_clicks_on_button(String userName, String password, String login) throws Throwable 
	{
		LoginPage.inputValidLoginDetails(userName, password, login);
	}

	//Then verify user is logged in
	@Then("^verify user is logged in$")
	public void verify_user_is_logged_in() throws Throwable 
	{
		HomePage.verificationOfUserLoggedIn();
	}
	
	//When user clicks on tile, Enrolment -> Your Details -> Personal Details
	@When("^user clicks on tile, Enrolment -> Your Details -> Personal Details$")
	public void user_clicks_on_tile_Enrolment_Your_Details_Personal_Details() throws Throwable 
	{
		EnrolmentPage.clicksOnEnrollmentYourDetailsAndPersonalDetails();
	}
	
	//And user gets the value from the Date of Birth field and change the current values to "<DOB>"
	@And("^user gets the value from the Date of Birth field and change the current values to \"([^\"]*)\"$")
	public void user_gets_the_value_from_the_Date_of_Birth_field_and_change_the_current_values_to(String dOB) throws Throwable 
	{
		EnrolmentPage.settingOfNewDate(dOB);
	}    
    
	//And user adds "<First_Name>" and "<Last_Name>" values Parent's / Guardian's Name section
	@And("^user adds \"([^\"]*)\" and \"([^\"]*)\" values Parent's / Guardian's Name section$")
	public void user_adds_and_values_Parent_s_Guardian_s_Name_section(String firstName, String lastName) throws Throwable 
	{
		EnrolmentPage.addFirstNameAndLastNameOnParentsSection(firstName, lastName);
	}

	//And adds "<Email_Address>" under Contact Information section and selects "<Gender_Type>" value in Gender section, now close the tile	
	@When("^adds \"([^\"]*)\" under Contact Information section and selects \"([^\"]*)\" value in Gender section, now close the tile$")
	public void adds_under_Contact_Information_section_and_selects_value_in_Gender_section_now_close_the_tile(String emailAddress, String genderType) throws Throwable 
	{
		EnrolmentPage.addEmailAndSelectGenderType(emailAddress, genderType);	
	}
     
	//Then user verifies Date of Birth as "<DOB>", Parent’s/Guardian’s First Name as "<First_Name>", Last Name as "<Last_Name>", Gender as "<Gender_Type>" Email Address as "<Email_Address>"
	@Then("^user verifies Date of Birth as \"([^\"]*)\", Parent’s/Guardian’s First Name as \"([^\"]*)\", Last Name as \"([^\"]*)\", Gender as \"([^\"]*)\" Email Address as \"([^\"]*)\"$")
	public void user_verifies_Date_of_Birth_as_Parent_s_Guardian_s_First_Name_as_Last_Name_as_Gender_as_Email_Address_as(String dOB, String firstName, String lastName, String genderType, String emailAddress) throws Throwable 
	{
		EnrolmentPage.verify_DOB_First_Name_Last_Name_Gender_Type(dOB, firstName, lastName, genderType, emailAddress);
	}
	
	//When user again reverses Date of Birth field "<DOB>" to defualt, "<First_Name>", "<Last_Name>",	"<Email_Address>" all blanks and Gender to be "<Gender_Type>"
	@When("^user again reverses Date of Birth field \"([^\"]*)\" to defualt, \"([^\"]*)\", \"([^\"]*)\",	\"([^\"]*)\" all blanks and Gender to be \"([^\"]*)\"$")
	public void user_again_reverses_Date_of_Birth_field_to_defualt_all_blanks_and_Gender_to_be(String dOB, String firstName, String lastName, String emailAddress, String genderType) throws Throwable 
	{
		EnrolmentPage.update_DOB_First_Name_Last_Name_Email_Address_Gender_Type(dOB, firstName, lastName, emailAddress, genderType);
	}
	
	//And user closes the tile (Use different way to close than used before), click on Angle down button on the top right of the page and click on "Log Out"
	@When("^user closes the tile \\(Use different way to close than used before\\), click on Angle down button on the top right of the page and click on \"([^\"]*)\"$")
	public void user_closes_the_tile_Use_different_way_to_close_than_used_before_click_on_Angle_down_button_on_the_top_right_of_the_page_and_click_on(String arg1) throws Throwable 
	{
		HomePage.returnToHomePage();
	}
	
	//Then verify user has logged out
	@Then("^verify user has logged out$")
	public void verify_user_has_logged_out() throws Throwable 
	{
		HomePage.logOutHomePage();
	}
	
	
	
	
	
	
  
}

