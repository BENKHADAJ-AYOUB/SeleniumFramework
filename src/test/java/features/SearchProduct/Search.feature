Feature: search product with her name

  @POECSOFT23-788 @POECSOFT23-789 @POECSOFT23-795
  Scenario: search product with her name
    Given the user in the home page for search product
    When I entered name product and click on search
    And i click on the product
    Then The details product page displayed successfully