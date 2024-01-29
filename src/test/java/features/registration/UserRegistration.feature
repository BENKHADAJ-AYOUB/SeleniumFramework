Feature: vérifie registration

  @POECSOFT23-781
  Scenario: vérifie registration
    Given the user in the home page
    When I click on register link
    And I entered for register
    And I entered for login
    Then The registration page displayed successfully
