#Auto generated Octane revision tag
@TID116001REV0.2.0
Feature: Login to workspace reporting tool hpsw

	Scenario: user can login into the reporting plattform
		Given user name is valid
        And password is valid 
		When user clicks on login button
		Then user is logged into the reporting tool
