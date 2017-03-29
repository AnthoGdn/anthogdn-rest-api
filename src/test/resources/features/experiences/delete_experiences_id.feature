Feature: Remove experience

  Background:
    Given there are these experiences data in database:
      | id | startDate  | endDate    | title             | languages | job      | description        | location | orderNb |
      | 0a | 2016-01-01 | 2017-01-01 | Master's Degree   | Spring    | Stage    | SOA and management | Rouen    | 0       |
      | 1a | 2015-01-01 | 2016-01-01 | Bachelor's Degree | JAVA - C  | Etudiant | Java               | Rouen    | 1       |

  Scenario: I make call to DELETE right entity.
    When I set a "DELETE" request to "/api/experiences/0a"
    And I send the request
    Then the response status code is 204
    And the experiences data database is:
      | id | startDate  | endDate    | title             | languages | job      | description        | location | orderNb |
      | 1a | 2015-01-01 | 2016-01-01 | Bachelor's Degree | JAVA - C  | Etudiant | Java               | Rouen    | 1       |


  Scenario: I make call to DELETE non-existent entity.
    When I set a "DELETE" request to "/api/experiences/incorrectId"
    And I send the request
    Then the response status code is 404
    And the experiences data database is:
      | id | startDate  | endDate    | title             | languages | job      | description        | location | orderNb |
      | 0a | 2016-01-01 | 2017-01-01 | Master's Degree   | Spring    | Stage    | SOA and management | Rouen    | 0       |
      | 1a | 2015-01-01 | 2016-01-01 | Bachelor's Degree | JAVA - C  | Etudiant | Java               | Rouen    | 1       |