	Feature: Login functionality on airasia.com website
	@login
	Scenario: User tries to login to Airasia application with invalid crendentials
		Given User navigates to airasia website
		Then Verify the title of page
		When User clicks on login button
		And User enters username as "abca@gmail.com"
		And User enters some random OTP
		Then Verify the error message is displayed or not