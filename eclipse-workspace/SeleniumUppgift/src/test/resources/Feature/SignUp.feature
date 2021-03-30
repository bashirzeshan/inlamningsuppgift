Feature: In order to use this application
         I want to register myself as a new user
 
  Scenario Outline: Sign up functionality
    Given user is on the application sign up page
    When I enter EmailID address as "<EmailID>"
    And I enter Username  "<Username>""<Newuser>"
    And I enter Password "<Password>"
    And I click on the sign up
    Then the new user should be created "<Newuser>"

    @NewUser
    Examples: 
      | EmailID               | Username    | Password    | Newuser |
      | zb001234@username.com | xyz123456 | Test?tes123 | No      |

    @UserNameIsNotValid
    Examples: 
      | EmailID               | Username                                                                                                                                                                                                                                                                        | Password    | Newuser |
      | zb001234@username.com | ab646464646uidhweuifhiuwefhueiwhfuiewhfuiewhfiuewhfiuewhfiuewhfiuewhfiuewhfiuwehfiuewhfiuewhfiuewhfiuewhfiuwehfuiewhfiuewhfiuewhfiuewhfiuewhfiuewhfiuewhf1222323hioh2ioehi2e21eih21iuehiu12heiu12heiu13heiuh31eiruh13iurhiu13heiu12heiu12heiu12heui12he1ihei12hei12hei21hei12he | Test?tes123 | No      |

    @EmailIsMissing
    Examples: 
      | EmailID | Username  | Password    | Newuser |
      |         | ab64343s1 | Test?tes123 | No      |

    @UserAlreadyExists
    Examples: 
      | EmailID               | Username | Password    | Newuser |
      | zb001234@username.com | user     | Test?tes123 | No      |
