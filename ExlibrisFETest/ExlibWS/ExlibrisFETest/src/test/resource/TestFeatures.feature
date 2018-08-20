@start
Feature: End to End testing for campusm App

  @tag
  Scenario Outline: Functionilty test for integrated units for campusm
    Given user navigates to campusm site "<URL>"
    When user selects "Student / Staff"
    And clicks on "Accept" button
    And enters the values for "<Username>" and "<Password>"
    Then user should verify "Login" button is displayed and clicks it
    And user should also verify error message displayed is "Please try again."
    When user enter the values for "<Username>" and "<Password>" and clicks on "Login" button
    Then verify user is logged in
    When user clicks on tile, Enrolment -> Your Details -> Personal Details
    And user gets the value from the Date of Birth field and change the current values to "<DOB>"
    And user adds "<First_Name>" and "<Last_Name>" values Parent's / Guardian's Name section
    And adds "<Email_Address>" under Contact Information section and selects "<Gender_Type>" value in Gender section, now close the tile
    When user clicks on tile, Enrolment -> Your Details -> Personal Details
    Then user verifies Date of Birth as "<DOB>", Parent’s/Guardian’s First Name as "<First_Name>", Last Name as "<Last_Name>", Gender as "<Gender_Type>" Email Address as "<Email_Address>"
    When user again reverses Date of Birth field "<DOB>" to defualt, "<First_Name>", "<Last_Name>",	"<Email_Address>" all blanks and Gender to be "<Gender_Type>"
    And user closes the tile (Use different way to close than used before), click on Angle down button on the top right of the page and click on "Log Out"
    Then verify user has logged out

    Examples: 
      | URL                            | Username                 | Password          | DOB        | First_Name | Last_Name  | Email_Address               | Gender_Type            |
      | https://m.campusm.org/campusm/ | Your First Name,joshua.c | Any value,campusm | 27/12/1990 | Demo,blank | User,blank | demo.user@myemail.com,blank | Male,Perfer not to say |
