Feature: Get project

  Background:
    Given there are these projects data in database:
      | id | startDate  | endDate    | title             | languages | partnerTeamNb | job      | description        | location | orderNb |
      | 0a | 2016-01-01 | 2017-01-01 | Master's Degree   | Spring    | 7             | Stage    | SOA and management | Rouen    | 0       |
      | 1a | 2015-01-01 | 2016-01-01 | Bachelor's Degree | JAVA - C  | 7             | Etudiant | Java               | Rouen    | 1       |

  Scenario: I make call to GET right project.
    When I set a "GET" request to "/api/projects/0a"
    And I send the request
    Then the response status code is 200
    And the projects data database is:
      | id | startDate  | endDate    | title             | languages | partnerTeamNb | job      | description        | location | orderNb |
      | 0a | 2016-01-01 | 2017-01-01 | Master's Degree   | Spring    | 7             | Stage    | SOA and management | Rouen    | 0       |
      | 1a | 2015-01-01 | 2016-01-01 | Bachelor's Degree | JAVA - C  | 7             | Etudiant | Java               | Rouen    | 1       |
    And the response body matches :
      | id            | 0a                 |
      | title         | Master's Degree    |
      | languages     | Spring             |
      | partnerTeamNb | 7                  |
      | job           | Stage              |
      | description   | SOA and management |
      | location      | Rouen              |


  Scenario: I make call to GET non-existent project.
    When I set a "GET" request to "/api/projects/incorrectId"
    And I send the request
    Then the response status code is 404
    And the projects data database is:
      | id | startDate  | endDate    | title             | languages | partnerTeamNb | job      | description        | location | orderNb |
      | 0a | 2016-01-01 | 2017-01-01 | Master's Degree   | Spring    | 7             | Stage    | SOA and management | Rouen    | 0       |
      | 1a | 2015-01-01 | 2016-01-01 | Bachelor's Degree | JAVA - C  | 7             | Etudiant | Java               | Rouen    | 1       |
