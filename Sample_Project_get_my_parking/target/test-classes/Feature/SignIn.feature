@SignIn  @OnBoarding @RegressionSuite @Sanity
Feature: Sign In
  User landed to Sign In page and functional flow  and Error messages


  Scenario Outline: Verify user not logged in with Invalid emailId or Password
    Given user clear cache and launch browser home page
    When User click on login link and navigate to login page
    Then verify user landed to signIn page
    Then verify all UI components in sign in screen
    And validate error message in signIn screen
    And  customer enter invalid "<email>" and password "<password>"
    Then Verify customer not able to signIn
    And customer click on forgot password link


    @loginValidation
    @Auth

    Examples:
      | email              | password  |
      | landmark@gmail.com | abcd@2000 |


  Scenario Outline: Verify user logged in with valid emailId and Password
    Given user clear cache and launch browser home page
    When  User click on login link and navigate to login page
    And  customer enter valid "<email>" and password "<password>"
    Then verify customer landed to otp verify page
    And Customer lander home page
     And  User click on myAccount drop icon
    And customer click on myAccount drop down icon for drop down items
    And customer click on sign out item from drop down



    @Auth
    Examples:
      | email                  | password     |
      | foraxew541@marikuza.com | Munagala@123 |

  Scenario: Verify user landed to sign up screen
    When  User click on login link and navigate to login page
    Then  User click on "Sign up For One" to navigate to sign up page

  Scenario: clear cache and land to browser home page
    And user clear cache and launch browser home page