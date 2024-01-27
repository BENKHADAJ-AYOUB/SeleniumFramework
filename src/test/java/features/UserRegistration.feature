Feature: User Registration   I want to check that the user can register in our e-commerce website.
  @PGR4-133
  Scenario: User Registration   I want to check that the user can register in our e-commerce website.
    Given the user in the home page
    When I click on register link
    And I entered for register
    And I entered for login
    Then The registration page displayed successfully

