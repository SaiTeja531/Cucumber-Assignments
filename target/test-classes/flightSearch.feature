Feature: User should be able to search for flights 
	User enters source, destination locations and jouney date on home page then user should be displayed with particular search results
	@flight
	Scenario: User enters source, destination, journey date then flights according to the particulars should be displayed
		Given User navigates to airasia website
		Then Verify the title of page
		When User selects source location
		|Bengaluru|
		And Users selects destination location
		|Pune|
		And User selects one way option
		And User selects departure date as "15/12/2022"		
		And User clicks on search fligh button
		Then verify user is navigated to search flight page
		
	

		
	
		
		