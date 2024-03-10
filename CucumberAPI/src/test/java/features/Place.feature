Feature: Validating Place API's

@AddPlace @Regression
Scenario Outline: Verify if place is being succesfully added/get/deleted using Place API
#in order to perform add place method - we need add an address
Given Add Place Payload with "<name>" "<language>" "<address>"
When user calls "AddPlaceAPI" API using "POST" http request
Then the API call got success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
#in order to perform get place method - we need the attribute "place id"
And verify if place_id created maps to the "<name>" using "GetPlaceAPI"


Examples:
				| name 			| language 	| address 		|
				| ABC house | english 	| world center|
#				|	def house | hindi			| empire state|

@DeletePlace @Regression
Scenario: Verify if place is being succesfully deleted using Place API
#in order to perform delete place method - we need to delete an address
Given DeletePlace Payload
When user calls "DeletePlaceAPI" API using "POST" http request
Then the API call got success with status code 200
And "status" in response body is "OK"