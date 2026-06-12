Scenario: Create a valid ticket
Given no ticket exists
When I create a valid ticket
Then the response status should be 201
And the returned ticket should be open