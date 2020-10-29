Feature:Negative Test Cases Of Sentence Array

  Scenario: To Verify that the ShowMenu will be displayed when the user calls showMenu Method
    Given The application is started
    Then the application menu should be displayed

  Scenario: To Verify that option 2 works correctly
    Given The application is started
    And user enters the second option
#    Then the application should display an error message