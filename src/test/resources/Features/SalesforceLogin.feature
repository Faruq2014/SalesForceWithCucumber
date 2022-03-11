@Reg @Login1
Feature: I want to test Login functionality

  @tag11
  Scenario: As a tester I want to test negative login functionality
    Given user open SalesForce Appl
    When user enter userName and Password
    Then user validate error message
    
   