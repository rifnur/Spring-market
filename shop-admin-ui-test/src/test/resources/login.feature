Feature: Login

  Scenario Outline: Successful Login to the page and logout after
    Given I open web browser
    When I navigate to login page
    And I provide username as "<username>" and password as "<password>"
    And I click on login button
    When I navigate to brands page
    And I click create brands
    And I add brand
    And I save brands
    And I navigate to brands page
    Then name should be "<name>"
    When Open dropdown menu
    And click logout button
    Then user logged out

    Examples:
      | username | password | name |
      | admin | admin | admin |