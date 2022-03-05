@Login
Feature: I want to test Login functionality

  @db
  Scenario: As a tester I want to test negative login functionality from Data Base
    Given user open SalesForce Application from local
    When user enter userName and Password from DataBase
    Then user validate DataBase for Data Validity
    

