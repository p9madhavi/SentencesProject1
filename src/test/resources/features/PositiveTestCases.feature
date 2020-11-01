Feature:Positive Test Cases Of Sentence Array

  Scenario: To Verify that the ShowMenu will be displayed when the user calls showMenu Method
    Given The application is started
    Then the application menu should be displayed

  Scenario: To Verify that option 2 works correctly
    Given The application is started
    When user enters two sentences by following prompts
    And user enters the second option
    Then the application should display all the sentences

  Scenario: To Verify that option 3 works correctly
    Given The application is started
    When user enters two sentences by following prompts
    And user enters the third option
    Then the application should display the count of the sentences

  Scenario: To Verify that option 4 works correctly
    Given The application is started
    When user enters two sentences by following prompts
    And user enters the fourth option
    Then the application should display all the sentences in the reverse order

  Scenario: To Verify that option 5 works correctly
    Given The application is started
    When user enters two sentences by following prompts
    And user enters the fifth option
    Then the application should display the number of characters

  Scenario: To Verify that option 6 works correctly
    Given The application is started
    When user enters two sentences by following prompts
    And user enters the sixth option
    Then the application should display the total number of vowels

  Scenario: To Verify that option 7 works correctly
    Given The application is started
    When user enters two sentences by following prompts
    And user enters the seventh option
    And user enters "LITTLE" as the search word
    Then the application should display the second sentence

  Scenario: To Verify that option 8 works correctly
    Given The application is started
    When user enters two sentences by following prompts
    And user enters the eighth option
    And user enters "mother" as the search word which is caseSensitive
    Then the application should display the first sentence







