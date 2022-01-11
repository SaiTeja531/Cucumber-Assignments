Feature: Registration functionality for newtourtravels
		@travel	
	Scenario Outline: Users registers for new tours website
		Given User navigates to newtourtravels website
		When User clicks on register button
		Then User enters firstname "<firstname>"
		And User enters lastname "<lastname>"
		And User enters Phone "<Phone>"
		And User enters Email "<Email>"
		And User enters Address "<Address>"
		And User enters City "<City>"
		And User enters State "<State/Province>"
		And User enters Postal "<Postal Code>"
		And User enters Country "<Country>"
		And User enters User "<User Name>"
		And User enters Password "<Password>"
		And User enters Confirm "<Confirm Password>"
		And User clicks on submit button
		Examples:
		| firstname | lastname | Phone | Email | Address | City | State/Province | Postal Code | Country | User Name | Password | Confirm Password |
		|sake|asss|42323234|a@gmail.com|aafdffffa|hyd|daadsda|241213|ANGOLA|ssas|ssas|ssas|
		|sadi|dada|97980909|b@gmail.com|adkslkala|culcutta|kaalj|29031|ALBANIA|jhjh|jkj|jkj|
		|john|man|7979797|c@gmail.com|gjhgjjkhk|bangalore|fhfhj|768998|ANTARCTICA|SASA|qwerty|qwerty|
		|bunny|sam|8798889|d@gmail.com|uhjhkj|hyderabad|hjhjgj|879909|BAHAMAS|ZASA|dash|dash|
		|durga|gan|0980980|e@gmail.com|iuadioadi|janagoan|akjdka|928129|ARMENIA|dasa|mash|mash|
		|sunny|ban|8090009|f@gmail.com|kajdalaal|delhi|aksdjaj|980800|INDIA|sunny|sun|sun|
		|chinny|fan|980908|g@gmail.com|oiwdioaj|haryana|kasjdla|2837921|INDIA|chinny|bun|bun|
		|gannu|bannu|987979|h@gmail.com|iwldkja|bangkok|ajdak|2879312|ICELAND|gannu|bannu|bannu|
		|Samuel|Patterson|090009|i@gmail.com|oajlda|hammold|adjal|29128|HUNGARY|sam|bam|bam|
		|Michael|Hensley|298928|j@gmail.com|kajdak|brookly|isjdaskl|92892|HONDURAS|michael|mike|mike|