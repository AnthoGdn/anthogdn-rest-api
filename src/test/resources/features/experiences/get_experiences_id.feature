Feature: Get experience

  Background:
    Given there are these experiences data in database:
      | id | startDate  | endDate    | title             | languages | job      | description        | location | orderNb |
      | 0a | 2016-01-01 | 2017-01-01 | Master's Degree   | Spring    | Stage    | SOA and management | Rouen    | 0       |
      | 1a | 2015-01-01 | 2016-01-01 | Bachelor's Degree | JAVA - C  | Etudiant | Java               | Rouen    | 1       |

  Scenario: I make call to GET right experience.
    When I set a "GET" request to "/api/experiences/0a"
    And I send the request
    Then the response status code is 200
    And the experiences data database is:
      | id | startDate  | endDate    | title             | languages | job      | description        | location | orderNb |
      | 0a | 2016-01-01 | 2017-01-01 | Master's Degree   | Spring    | Stage    | SOA and management | Rouen    | 0       |
      | 1a | 2015-01-01 | 2016-01-01 | Bachelor's Degree | JAVA - C  | Etudiant | Java               | Rouen    | 1       |
    And the response body matches :
      | id          | 0a                 |
      | title       | Master's Degree    |
      | languages   | Spring             |
      | job         | Stage              |
      | description | SOA and management |
      | location    | Rouen              |


  Scenario: I make call to GET non-existent experience.
    When I set a "GET" request to "/api/experiences/incorrectId"
    And I send the request
    Then the response status code is 404
    And the experiences data database is:
      | id | startDate  | endDate    | title             | languages | job      | description        | location | orderNb |
      | 0a | 2016-01-01 | 2017-01-01 | Master's Degree   | Spring    | Stage    | SOA and management | Rouen    | 0       |
      | 1a | 2015-01-01 | 2016-01-01 | Bachelor's Degree | JAVA - C  | Etudiant | Java               | Rouen    | 1       |