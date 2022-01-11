Feature: Register functionality in automationpratice.com website
	@automation_practice
	Scenario Outline: User registers in automationpractice.com website
		Given User navigates to automationpratice.com website
		When User clicks on sign in button
		And User enters a valid "<email>"
		And  User clicks on create an account button 
		Then User should land on registration page
		When User selects salutation "<salutation>"
		And User enters FirstName "<FirstName>"
		And User enters his LastName "<LastName>"
		And User enters new password "<password>"
		And User selects date of birth "<DOB>"
		And User enters company name "<company>"
		And User enters resident address "<adress>"
		And User selects country "<country>"
		And User enters resident city "<city>"
		And User selects state "<state>"
		And User enters zipCode "<zipcode>"
		And Users enters mobile number "<mobile>"
		And User clicks Register button
		Then verify user is successfully registered and landed on "MY ACCOUNT" page
		Examples:
		|email|salutation|FirstName|LastName|password|DOB|company|adress|city|country|state|zipcode|mobile|
		|haaddaasm@gmail.com|Mr|gannu|bannu|bannu123|22/11/2021|technofi|banglore gandhi street|bangalore|United States|Alabama|23422|0923010|
		|namsaaasa@gmail.com|Mrs|chinny|smith|chinny123|23/11/1997|CGI|madhura nagar newyork|newyork|United States|New York|98098|09823901|
		|samfdffas@gmail.com|Mr|same|peterson|sam1234|23/10/1978|Uplers|kennedy street|washington|United States|Washington|09808|9989878787|
		