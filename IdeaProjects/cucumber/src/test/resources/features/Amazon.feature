Feature:Amazon website usage

Scenario: Verify that the user is able to enter url and able to view homepage
  Given user navigates to the browser's url tab
  When user enters the url
  Then the chrome is launched

  Scenario: Verify that the user can able to search a product
    Given the user navigates to the home page
    When the user enter the product name
    Then the product result should be displayed

  Scenario:Verify that the user is able to sign in to the website
    Given user navigates to the signin page here
    When the user enters phone number and password
    Then user is able to signin

  Scenario: Verify user is able to navigate to gift section
    Given the user navigates to  home page
    When the user is able to click on gift bar and navigate to gift section
    Then the user is able to view the gifts

    Scenario: Verify that the user is able search items//6
      Given  user navigates to the home page
      When user clicks on search bar without entering characters
      Then user is not able to find any answer
  @smoke
  Scenario: Verif that the user is not able to signin without entering credentils
    Given User is able to move to sign in page
    When user doesnt enter any credentials in sign in page
    Then user is not able sign in

 Scenario Outline: Verify user is signing to amazon

   Given user is on homepage
   When user enters to sign in page
   And User enters "<phonenumber>" and "<password>"
   Then user is able to signin successfully
   Examples:
   |  phonenumber |    |  password  |
   |  9148386385  |    |  Sowmya@123|
   |  9845604585  |    |  hello@123 |
