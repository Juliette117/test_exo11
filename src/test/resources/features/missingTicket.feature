Scenario: Read a missing ticket
Given no ticket exists
When I read ticket 999
Then the response status should be 404
And the response should explain that the ticket was not found