Feature: Get All languages
  Background:
    Given there are these languages data in database:
    | id    | name  | level   | url                                     |
    | 1a    | JAVA  | HIGH    | https://www.anthogdn.fr/public/java.png |
    | 2a    | PHP   | GOOD    | https://www.anthogdn.fr/public/php.png  |
    | 3a    | C     | MIDDLE  | https://www.anthogdn.fr/public/c.png    |
    | 4a    | CSS   | MIDDLE  | https://www.anthogdn.fr/public/css.png  |

  Scenario: I make call to GET /languages
    When I set a "GET" request to "/api/languages"
    And I send the request
    Then the response status code is 200
    And the "Content-Type" attribute of the response header is "application/json;charset=UTF-8"
    And the response body matches :

#      | data[0].id          | 1a                                      |
      | data[0].name        | JAVA                                    |
      | data[0].level       | HIGH                                    |
      | data[0].imgURL      | https://www.anthogdn.fr/public/java.png |

#      | data[1].id          | 2a                                      |
      | data[1].name        | PHP                                     |
      | data[1].level       | GOOD                                    |
      | data[1].imgURL      | https://www.anthogdn.fr/public/php.png  |

#      | data[2].id          | 3a                                      |
      | data[2].name        | C                                       |
      | data[2].level       | MIDDLE                                  |
      | data[2].imgURL      | https://www.anthogdn.fr/public/c.png    |

#      | data[3].id          | 4a                                      |
      | data[3].name        | CSS                                     |
      | data[3].level       | MIDDLE                                  |
      | data[3].imgURL      | https://www.anthogdn.fr/public/css.png  |


      
