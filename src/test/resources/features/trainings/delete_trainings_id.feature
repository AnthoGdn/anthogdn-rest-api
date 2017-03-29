Feature: Remove training

  Background:
    Given there are these trainings data in database:
      | id | startDate  | endDate    | title             | description        | location | orderNb |
      | 0a | 2016-01-01 | 2017-01-01 | Master's Degree   | SOA and management | Rouen    | 0       |
      | 1a | 2015-01-01 | 2016-01-01 | Bachelor's Degree | Java               | Rouen    | 0       |

  Scenario: I make call to DELETE right entity.
    When I set a "DELETE" request to "/api/trainings/0a"
    And I send the request
    Then the response status code is 204
    And the trainings data database is:
      | id | startDate  | endDate    | title             | description | location | orderNb |
      | 1a | 2015-01-01 | 2016-01-01 | Bachelor's Degree | Java        | Rouen    | 0       |


  Scenario: I make call to DELETE non-existent entity.
    When I set a "DELETE" request to "/api/trainings/incorrectId"
    And I send the request
    Then the response status code is 404
    And the trainings data database is:
      | id | startDate  | endDate    | title             | description        | location | orderNb |
      | 0a | 2016-01-01 | 2017-01-01 | Master's Degree   | SOA and management | Rouen    | 0       |
      | 1a | 2015-01-01 | 2016-01-01 | Bachelor's Degree | Java               | Rouen    | 0       |