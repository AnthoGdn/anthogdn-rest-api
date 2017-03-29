Feature: Put tool
  Background:
    Given there are these tools data in database:
      | id    | name  | level   | url                                     | orderNb |
      | 0a    | JAVA  | HIGH    | https://www.anthogdn.fr/public/java.png | 0       |
      | 1a    | PHP   | GOOD    | https://www.anthogdn.fr/public/php.png  | 1       |
      | 2a    | C     | MIDDLE  | https://www.anthogdn.fr/public/c.png    | 2       |
      | 3a    | CSS   | MIDDLE  | https://www.anthogdn.fr/public/css.png  | 3       |

  Scenario: I make call to PUT right tool.
    When I set a "PUT" request to "/api/tools/0a"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      {
        "name":"JAVA EE",
        "level":"GOOD",
        "imgURL":"https://www.anthogdn.fr/public/javaee.png"
      }
    """
    And I send the request
    Then the response status code is 200
    And the tools data database is:
      | id    | name    | level   | url                                       | orderNb |
      | 0a    | JAVA EE | GOOD    | https://www.anthogdn.fr/public/javaee.png | 0       |
      | 1a    | PHP     | GOOD    | https://www.anthogdn.fr/public/php.png    | 1       |
      | 2a    | C       | MIDDLE  | https://www.anthogdn.fr/public/c.png      | 2       |
      | 3a    | CSS     | MIDDLE  | https://www.anthogdn.fr/public/css.png    | 3       |
    And the response body matches :
      | id           | 0a                                         |
      | name         | JAVA EE                                    |
      | level        | GOOD                                       |
      | imgURL       | https://www.anthogdn.fr/public/javaee.png  |


  Scenario: I make call to PUT entity without json in body request.
    When I set a "PUT" request to "/api/tools/0a"
    And I send the request
    Then the response status code is 400
    And the tools data database is:
      | id    | name  | level   | url                                     | orderNb |
      | 0a    | JAVA  | HIGH    | https://www.anthogdn.fr/public/java.png | 0       |
      | 1a    | PHP   | GOOD    | https://www.anthogdn.fr/public/php.png  | 1       |
      | 2a    | C     | MIDDLE  | https://www.anthogdn.fr/public/c.png    | 2       |
      | 3a    | CSS   | MIDDLE  | https://www.anthogdn.fr/public/css.png  | 3       |

  Scenario: I make call to PUT bad tool.
    When I set a "PUT" request to "/api/tools/01"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      {
        "toto":"JAVA EE",
        "level":"GOOD",
        "imgURL":"https://www.anthogdn.fr/public/javaee.png"
      }
    """
    And I send the request
    Then the response status code is 400
    And the tools data database is:
      | id    | name  | level   | url                                     | orderNb |
      | 0a    | JAVA  | HIGH    | https://www.anthogdn.fr/public/java.png | 0       |
      | 1a    | PHP   | GOOD    | https://www.anthogdn.fr/public/php.png  | 1       |
      | 2a    | C     | MIDDLE  | https://www.anthogdn.fr/public/c.png    | 2       |
      | 3a    | CSS   | MIDDLE  | https://www.anthogdn.fr/public/css.png  | 3       |

  Scenario: I make call to PUT non-existent tool.
    When I set a "PUT" request to "/api/tools/incorrectId"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      {
        "name":"JAVA EE",
        "level":"GOOD",
        "imgURL":"https://www.anthogdn.fr/public/javaee.png"
      }
    """
    And I send the request
    Then the response status code is 404
    And the tools data database is:
      | id    | name  | level   | url                                     | orderNb |
      | 0a    | JAVA  | HIGH    | https://www.anthogdn.fr/public/java.png | 0       |
      | 1a    | PHP   | GOOD    | https://www.anthogdn.fr/public/php.png  | 1       |
      | 2a    | C     | MIDDLE  | https://www.anthogdn.fr/public/c.png    | 2       |
      | 3a    | CSS   | MIDDLE  | https://www.anthogdn.fr/public/css.png  | 3       |