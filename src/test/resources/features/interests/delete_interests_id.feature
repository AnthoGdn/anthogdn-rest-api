Feature: Remove interest

  Background:
    Given there are these interests data in database:
      | id | name        | url                                            | type           | orderNb |
      | 0a | Programming | https://www.anthogdn.fr/public/programming.png | Passions       | 0       |
      | 1a | Trips       | https://www.anthogdn.fr/public/trips.png       | Passions       | 1       |
      | 2a | Sport       | https://www.anthogdn.fr/public/sport.png       | Entertainments | 2       |
      | 3a | Movies      | https://www.anthogdn.fr/public/movies.png      | Entertainments | 3       |

  Scenario: I make call to DELETE right entity.
    When I set a "DELETE" request to "/api/interests/0a"
    And I send the request
    Then the response status code is 204
    And the interests data database is:
      | id | name   | url                                       | type           | orderNb |
      | 1a | Trips  | https://www.anthogdn.fr/public/trips.png  | Passions       | 1       |
      | 2a | Sport  | https://www.anthogdn.fr/public/sport.png  | Entertainments | 2       |
      | 3a | Movies | https://www.anthogdn.fr/public/movies.png | Entertainments | 3       |


  Scenario: I make call to DELETE non-existent entity.
    When I set a "DELETE" request to "/api/interests/incorrectId"
    And I send the request
    Then the response status code is 404
    And the interests data database is:
      | id | name        | url                                            | type           | orderNb |
      | 0a | Programming | https://www.anthogdn.fr/public/programming.png | Passions       | 0       |
      | 1a | Trips       | https://www.anthogdn.fr/public/trips.png       | Passions       | 1       |
      | 2a | Sport       | https://www.anthogdn.fr/public/sport.png       | Entertainments | 2       |
      | 3a | Movies      | https://www.anthogdn.fr/public/movies.png      | Entertainments | 3       |