Scenario: Refuse to update an already resolved ticket
Given a resolved ticket exists
When I try to move the ticket back to in progress
Then the response status should be 409
And the response should explain that the transition is not allowed