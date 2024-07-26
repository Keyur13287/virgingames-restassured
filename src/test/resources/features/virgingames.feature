Feature: Testing different request on the virgin games application

  @smoke
  Scenario: Check if the virgin games application can be accessed by currencies
    When User sends a GET request to jackpots endpoint
    Then User must get back a valid status code 200

  @smoke
  Scenario Outline: Verify the Bingo jackpots as per selected currency is changed or not
    When User sends a GET request to jackpots endpoint
    Then User must get back a valid status code 200 as per"<currency>"
    Examples:
      | currency |
      | SEK|
      | GBP|
      | EUR|