Feature: Verify the form validation fields 

Scenario: Validate the fields are accepting input 
	Given the user in form validation page 
	When enter values in all the form input fields 
	Then user should be able to input successfully 
	And Click submit button , form should be submitted successfully 
	
