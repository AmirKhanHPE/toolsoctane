#Auto generated Octane revision tag
@TID103018REV0.3.0
Feature: Login to CPR
Das beschreibt mein Feature


	Scenario: Login with valid user
		Given navigate to CPR
        And page is loaded
        And user and password are provided and valid
		When user clicks on Login button
		Then user is logged into CPR
