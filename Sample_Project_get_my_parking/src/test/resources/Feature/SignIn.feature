@Dream11 @RegressionSuite @Sanity
Feature: Mobile: Functional Flows
  Verify functional flows in Dream11


  Scenario Outline: Verify functional flows in Dream11
    When User enter username "<email>" and password "<password>"
    And clicks on login
    Then User Select a Game As "Cricket"
    And User Select a Match as "Ind Vs Aus"
    Then User select a players As
      | playerName |
      | Kohli      |
      | Dhoni      |
      | Rohit      |
      | Bhumra     |
    Then Then User create a Team


    @Auth
    Examples:
      | email                  | password     |
      | godina5913@galcake.com | Munagala@123 |