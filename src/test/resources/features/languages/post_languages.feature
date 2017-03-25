Feature: Add languages


  Scenario: I make call to POST /languages.
    When I set a "POST" request to "/api/languages"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      [
        {
          "name":"JAVA",
          "level":"HIGH",
          "imgURL":"https://www.anthogdn.fr/public/java.png"
        },{
          "name":"PHP",
          "level":"GOOD",
          "imgURL":"https://www.anthogdn.fr/public/php.png"
        },{
          "name":"C",
          "level":"MIDDLE",
          "imgURL":"https://www.anthogdn.fr/public/c.png"
        },{
          "name":"CSS",
          "level":"MIDDLE",
          "imgURL":"https://www.anthogdn.fr/public/css.png"
        }
      ]
    """
    And I send the request
    Then the response status code is 201
    And the "Content-Type" attribute of the response header is "application/json;charset=UTF-8"
    And the languages data database is:
      | name  | level   | url                                     | orderNb |
      | JAVA  | HIGH    | https://www.anthogdn.fr/public/java.png | 0       |
      | PHP   | GOOD    | https://www.anthogdn.fr/public/php.png  | 1       |
      | C     | MIDDLE  | https://www.anthogdn.fr/public/c.png    | 2       |
      | CSS   | MIDDLE  | https://www.anthogdn.fr/public/css.png  | 3       |
    And the response body matches :
      | [0].name         | JAVA                                    |
      | [0].level        | HIGH                                    |
      | [0].imgURL       | https://www.anthogdn.fr/public/java.png |

      | [1].name         | PHP                                     |
      | [1].level        | GOOD                                    |
      | [1].imgURL       | https://www.anthogdn.fr/public/php.png  |

      | [2].name         | C                                       |
      | [2].level        | MIDDLE                                  |
      | [2].imgURL       | https://www.anthogdn.fr/public/c.png    |

      | [3].name         | CSS                                     |
      | [3].level        | MIDDLE                                  |
      | [3].imgURL       | https://www.anthogdn.fr/public/css.png  |