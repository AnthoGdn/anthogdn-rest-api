Feature: Get All languages
  Scenario: client makes call to GET /languages
    When the client calls /languages
    Then the client receives status code of 200
