@Reg
Feature: I want to test Login functionality

  @db2
  Scenario: As a tester I want to test negative login functionality from Data Base
    Given user open SalesForce Application from chrome
    When user enter 'userName' and 'Password' from DataBase2
    Then user validate DataBase2 for Data Validity