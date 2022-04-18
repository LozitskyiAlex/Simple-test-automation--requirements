Feature: Simple test automation

  Scenario: Log in successful
    Given I open https://default.fashlab-staging.fashcon.com/
    When I click on element by text: Sign In
    And I enter qa@mementia.com to Email
    And I enter Testpass1 to Password
    And I click on element by value: Log in
    Then I check that page contains text: Sign out
    And I check that page contains text: Home