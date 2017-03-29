Feature: Get training

  Background:
    Given there are these trainings data in database:
      | id | startDate  | endDate    | title             | description        | location | orderNb |
      | 0a | 2016-00-00 | 2017-00-00 | Master's Degree   | SOA and management | Rouen    | 0       |
      | 1a | 2015-00-00 | 2016-00-00 | Bachelor's Degree | Java               | Rouen    | 0       |

  Scenario: I make call to GET right training.
    When I set a "GET" request to "/api/trainings/0a"
    And I send the request
    Then the response status code is 200
    And the trainings data database is:
      | id | startDate  | endDate    | title             | description        | location | orderNb |
      | 0a | 2016-00-00 | 2017-00-00 | Master's Degree   | SOA and management | Rouen    | 0       |
      | 1a | 2015-00-00 | 2016-00-00 | Bachelor's Degree | Java               | Rouen    | 0       |
    And the response body matches :
      | id          | 0a                 |
      | title       | Master's Degree    |
      | description | SOA and management |
      | location    | Rouen              |


  Scenario: I make call to GET non-existent training.
    When I set a "GET" request to "/api/trainings/incorrectId"
    And I send the request
    Then the response status code is 404
    And the trainings data database is:
      | id | startDate  | endDate    | title             | description        | location | orderNb |
      | 0a | 2016-00-00 | 2017-00-00 | Master's Degree   | SOA and management | Rouen    | 0       |
      | 1a | 2015-00-00 | 2016-00-00 | Bachelor's Degree | Java               | Rouen    | 0       |