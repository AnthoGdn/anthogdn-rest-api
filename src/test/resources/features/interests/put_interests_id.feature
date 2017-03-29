Feature: Put interest

  Background:
    Given there are these interests data in database:
      | id | name        | url                                            | type           | orderNb |
      | 0a | Programming | https://www.anthogdn.fr/public/programming.png | Passions       | 0       |
      | 1a | Trips       | https://www.anthogdn.fr/public/trips.png       | Passions       | 1       |
      | 2a | Sport       | https://www.anthogdn.fr/public/sport.png       | Entertainments | 2       |
      | 3a | Movies      | https://www.anthogdn.fr/public/movies.png      | Entertainments | 3       |

  Scenario: I make call to PUT right interest.
    When I set a "PUT" request to "/api/interests/0a"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      {
        "name":"Full Programming",
        "imgURL":"https://www.anthogdn.fr/public/fullprogramming.png",
        "type":"Full Passions"
      }
    """
    And I send the request
    Then the response status code is 200
    And the interests data database is:
      | id | name             | url                                                | type           | orderNb |
      | 0a | Full Programming | https://www.anthogdn.fr/public/fullprogramming.png | Full Passions  | 0       |
      | 1a | Trips            | https://www.anthogdn.fr/public/trips.png           | Passions       | 1       |
      | 2a | Sport            | https://www.anthogdn.fr/public/sport.png           | Entertainments | 2       |
      | 3a | Movies           | https://www.anthogdn.fr/public/movies.png          | Entertainments | 3       |
    And the response body matches :
      | id     | 0a                                                 |
      | name   | Full Programming                                   |
      | imgURL | https://www.anthogdn.fr/public/fullprogramming.png |
      | type   | Full Passions                                      |


  Scenario: I make call to PUT entity without json in body request.
    When I set a "PUT" request to "/api/interests/0a"
    And I send the request
    Then the response status code is 400
    And the interests data database is:
      | id | name        | url                                            | type           | orderNb |
      | 0a | Programming | https://www.anthogdn.fr/public/programming.png | Passions       | 0       |
      | 1a | Trips       | https://www.anthogdn.fr/public/trips.png       | Passions       | 1       |
      | 2a | Sport       | https://www.anthogdn.fr/public/sport.png       | Entertainments | 2       |
      | 3a | Movies      | https://www.anthogdn.fr/public/movies.png      | Entertainments | 3       |

  Scenario: I make call to PUT bad interest.
    When I set a "PUT" request to "/api/interests/01"
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
    And the interests data database is:
      | id | name        | url                                            | type           | orderNb |
      | 0a | Programming | https://www.anthogdn.fr/public/programming.png | Passions       | 0       |
      | 1a | Trips       | https://www.anthogdn.fr/public/trips.png       | Passions       | 1       |
      | 2a | Sport       | https://www.anthogdn.fr/public/sport.png       | Entertainments | 2       |
      | 3a | Movies      | https://www.anthogdn.fr/public/movies.png      | Entertainments | 3       |

  Scenario: I make call to PUT non-existent interest.
    When I set a "PUT" request to "/api/interests/incorrectId"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      {
        "name":"Programming",
        "imgURL":"https://www.anthogdn.fr/public/programming.png"
      }
    """
    And I send the request
    Then the response status code is 404
    And the interests data database is:
      | id | name        | url                                            | type           | orderNb |
      | 0a | Programming | https://www.anthogdn.fr/public/programming.png | Passions       | 0       |
      | 1a | Trips       | https://www.anthogdn.fr/public/trips.png       | Passions       | 1       |
      | 2a | Sport       | https://www.anthogdn.fr/public/sport.png       | Entertainments | 2       |
      | 3a | Movies      | https://www.anthogdn.fr/public/movies.png      | Entertainments | 3       |