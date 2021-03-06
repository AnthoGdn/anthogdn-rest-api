Feature: Put experience

  Background:
    Given there are these experiences data in database:
      | id | startDate  | endDate    | title             | languages | job      | description        | location | orderNb |
      | 0a | 2016-01-01 | 2017-01-01 | Master's Degree   | Spring    | Stage    | SOA and management | Rouen    | 0       |
      | 1a | 2015-01-01 | 2016-01-01 | Bachelor's Degree | JAVA - C  | Etudiant | Java               | Rouen    | 1       |

  Scenario: I make call to PUT right experience.
    When I set a "PUT" request to "/api/experiences/0a"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
     """
      {
        "startDate":"2017-01-01",
        "endDate":"2018-01-01",
        "title":"Intership in Saagie",
        "languages":"Spring - Angular 2",
        "job":"Developper",
        "description":"Saagie product development"
      }
    """
    And I send the request
    Then the response status code is 200
    And the response body matches :
      | id          | 0a                           |
      | title       | Intership in Saagie          |
      | languages   | Spring - Angular 2           |
      | job         | Developper                   |
      | description | Saagie product development  |


  Scenario: I make call to PUT entity without json in body request.
    When I set a "PUT" request to "/api/experiences/0a"
    And I send the request
    Then the response status code is 400

  Scenario: I make call to PUT bad experience.
    When I set a "PUT" request to "/api/experiences/01"
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

  Scenario: I make call to PUT non-existent experience.
    When I set a "PUT" request to "/api/experiences/incorrectId"
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