Feature: User Registration   I want to check that the user can register in our e-commerce website.

  Background:


  @PGR4-133
  Scenario Outline: User Registration   I want to check that the user can register in our e-commerce website.
    Given the user in the home page
    When I click on register link
    And I entered for register "<firstname>" , "<lastname>" , "<email>" , "<password>"
    And I entered for login "<email>" , "<password>"
    Then The registration page displayed successfully


    Examples:
      | firstname | lastname | email                     | password |
      | ahmed     | mohamed  | skjsjlkfedsmd@user434.com | 12345678 |

