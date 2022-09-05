Feature: Purchasing and payment test-scenarios for “https://demo.midtrans.com/“
  Background: User is Logged In
    Given User navigate to the Home page
    Then He should be able open the correct page
  Scenario Outline: Validate if User is able to make the payment with given data for pillow as product
    Given Product link page with Buy now options
    When User click on Buy Now ,He should to be prompted to checkout
    And  When user click on checkout button order summary frame should be displayed with correct price <value>
    And  User click on ContinueButton for Payment
    And  User Select credit card as the payments method
    Then User should prompt to fill the card details As <CardNumber>, <Expire Date> and  <CVV>
    And  User Clicks on PayNow Button to continue
    Then User should prompt to fill the password or OTP and click on pay now button
    And  Order should be placed with done message
    Examples:
      | value         | CardNumber               | Expire Date     | CVV|
      | "20,000"      | "4811 1111 1111 1114"    | "1224"          |"123" |
      | "20,000"      | 4911 1111 1111 1113""    |"0220"           | "123"|

    

 
 