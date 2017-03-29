Feature: Get tool
  Background:
    Given there are these tools data in database:
      | id    | name  | level   | url                                     | orderNb |
      | 0a    | JAVA  | HIGH    | https://www.anthogdn.fr/public/java.png | 0       |
      | 1a    | PHP   | GOOD    | https://www.anthogdn.fr/public/php.png  | 1       |
      | 2a    | C     | MIDDLE  | https://www.anthogdn.fr/public/c.png    | 2       |
      | 3a    | CSS   | MIDDLE  | https://www.anthogdn.fr/public/css.png  | 3       |

  Scenario: I make call to GET right tool.
    When I set a "GET" request to "/api/tools/0a"
    And I send the request
    Then the response status code is 200
    And the tools data database is:
      | id    | name  | level   | url                                     | orderNb |
      | 0a    | JAVA  | HIGH    | https://www.anthogdn.fr/public/java.png | 0       |
      | 1a    | PHP   | GOOD    | https://www.anthogdn.fr/public/php.png  | 1       |
      | 2a    | C     | MIDDLE  | https://www.anthogdn.fr/public/c.png    | 2       |
      | 3a    | CSS   | MIDDLE  | https://www.anthogdn.fr/public/css.png  | 3       |
    And the response body matches :
      | id           | 0a                                      |
      | name         | JAVA                                    |
      | level        | HIGH                                    |
      | imgURL       | https://www.anthogdn.fr/public/java.png |


  Scenario: I make call to GET non-existent tool.
    When I set a "GET" request to "/api/tools/incorrectId"
    And I send the request
    Then the response status code is 404
    And the tools data database is:
      | id    | name  | level   | url                                     | orderNb |
      | 0a    | JAVA  | HIGH    | https://www.anthogdn.fr/public/java.png | 0       |
      | 1a    | PHP   | GOOD    | https://www.anthogdn.fr/public/php.png  | 1       |
      | 2a    | C     | MIDDLE  | https://www.anthogdn.fr/public/c.png    | 2       |
      | 3a    | CSS   | MIDDLE  | https://www.anthogdn.fr/public/css.png  | 3       |