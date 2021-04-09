Feature: In order to use this application
         I want to register myself as a new user

  Scenario Outline: Sign up functionality
    Given user is on the application sign up page
    When I enter EmailID address as "<EmailID>"
    And I enter Username  "<Username>""<Newuser>"
    And I enter Password "<Password>"
    And I click on the sign up
    Then the new user should be created "<Newuser>"

    Examples: 
      | EmailID | Username     | Password    | Newuser |
      | user    | valid        | Test?tes123 | No      |
      | user    | longuser     | Test?tes123 | No      |
      |         | valid        | Test?tes123 | No      |
      | user    | existinguser | Test?tes123 | No      |
