Scenario: Resolve a ticket
Given an open ticket exists
When I resolve the ticket
Then the response status should be 200
And the returned ticket should be resolved