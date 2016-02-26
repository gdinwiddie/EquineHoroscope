Feature: Pay with Credit Card

In order to sell on the internet, we accept credit card payments.
The protocol we follow is rather simplistic:
 1. Collect information from purchaser, including the following:
    * Credit Card number
    * Expiration date
    * CVV2 code
 2. Send that to our internal Payment Processor
 3. Receive back one of the following:
    * Successful authorization
    * Unsuccessful, with reason

Scenario: Declined by card issuer
	When a bad card is presented to the Payment Processor
	Then the Payment Processor declines the transaction

Scenario: Invalid card number

Scenario: Successful transaction
