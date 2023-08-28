Feature: E-commerce page

  Background: Browser have to be open and ready
    Given browser is been opened and ready

  @one
  Scenario Outline: User should be able to login using valid credentials
    Given User is in login page
    When user enters valid <username> and <password>
    And clicks submit button
    Then page displays a successful message
    And page gets closed
    Examples:
      | username | password |
      |name1     |pass1      |
      |try2      |pass2      |

  Scenario: User is able to add products to cart and checkout
    Given User is in product page
    When User clicks in add buttons for selected products
    And products are added to cart
    Then user clicks in cart button
    And user clicks in checkout button

#  Scenario: User returns to shopping page
#    Given User is in checkout page
#    When User clicks in Continue shopping button
#    Then Home page is displayed
#



