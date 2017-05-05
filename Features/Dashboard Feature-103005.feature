#Auto generated Octane revision tag
@TID103005REV0.2.0
Feature: Access Dashboard View

	Scenario: User can access personal dashboard view
		Given user is logged in
		When user clicks on my dashboard
		Then dashboard page is displayed
