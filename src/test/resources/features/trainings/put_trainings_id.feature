Feature: Put training

  Background:
    Given there are these trainings data in database:
      | id | startDate  | endDate    | title             | description        | location | orderNb |
      | 0a | 2016-01-01 | 2017-01-01 | Master's Degree   | SOA and management | Rouen    | 0       |
      | 1a | 2015-01-01 | 2016-01-01 | Bachelor's Degree | Java               | Rouen    | 0       |

  Scenario: I make call to PUT right training.
    When I set a "PUT" request to "/api/trainings/0a"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      {
          "startDate":"2016-01-02",
          "endDate":"2017-01-01",
          "title":"Master's Degree in Computer Science",
          "description":"SOA and management",
          "location":"France - Rouen"
        }
    """
    And I send the request
    Then the response status code is 200
    And the response body matches :
      | title       | Master's Degree in Computer Science |
      | description | SOA and management                  |
      | location    | France - Rouen                      |


  Scenario: I make call to PUT entity without json in body request.
    When I set a "PUT" request to "/api/trainings/0a"
    And I send the request
    Then the response status code is 400

  Scenario: I make call to PUT bad training.
    When I set a "PUT" request to "/api/trainings/01"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      {
        "toto":"Programming",
        "imgURL":"https://www.anthogdn.fr/public/programming.png"
      }
    """
    And I send the request
    Then the response status code is 400

  Scenario: I make call to PUT non-existent training.
    When I set a "PUT" request to "/api/trainings/incorrectId"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      {
        "startDate":"2016-01-02",
        "endDate":"2017-01-01",
        "title":"Master's Degree in Computer Science",
        "description":"SOA and management",
        "location":"France - Rouen"
      }
    """
    And I send the request
    Then the response status code is 404