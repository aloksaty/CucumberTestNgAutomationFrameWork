Feature: Ticket booking for bus
  Background: Login with userName and Password
    Given User open the home page
      |username|password|
      |alok    |Password@123|
    When User login with "UserName" and "Password"
    Then He should be able to login to booking application
    Scenario Outline: User Book the ticket by providing the passenger details
      Given : User navigate to ticket booking page
        |username|password|
        |alok    |Password@123|
      When He enter the <name> , <age> and <sex>
      And : click on submit button
      Then : He should be able to book the ticket
      Examples:
        |name|age|sex|
        |alok|30|m|
  Scenario Outline: User Book flight ticket by providing the passenger details
    Given : User navigate to flight ticket booking page
    #Given I am available on "Tuesday,Friday,Sunday"
    When He enter user details <countryCode> , <id>
    And : click on submit button
    Then : He should be able to book the ticket
    Examples:
      |countryCode|id|
      |USA|USA_001|