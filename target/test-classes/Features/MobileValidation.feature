#Author: RamaniC.email@your.domain.com
Feature: Redmi Mobile Validation
  I want to use this template for my feature file

  Background: 
    And user login by entering valid credentials

  Scenario: Mobile Check
    When user search mobile
    And user click mobile name
    Then user validates the mobile

  Scenario: Data Table
    When user search mobile by one dimensilnal list
      | Redmi | IPhone | Samsung |
    And user click mobile name
    Then user validates the mobile

  Scenario: Data Table
    When user search mobile by one dimensilnal map
      | 1 | IPhone  |
      | 2 | Samsung |
      | 3 | Realme  |
      | 4 | Sony    |
    And user click mobile name
    Then user validates the mobile

  Scenario Outline: 
    When user search mobile "<phone>"
    And user click mobile name
    Then user validates the mobile

    Examples: 
      | phone      |
      | IPhone     |
      | Sony Phone |
      | One Plus   |
