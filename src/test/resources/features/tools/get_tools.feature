Feature: Get All tools
  Background:
    Given there are these tools data in database:
      | id    | name  | level   | url                                     | orderNb |
      | 0a    | JAVA  | HIGH    | https://www.anthogdn.fr/public/java.png | 0       |
      | 1a    | PHP   | GOOD    | https://www.anthogdn.fr/public/php.png  | 1       |
      | 2a    | C     | MIDDLE  | https://www.anthogdn.fr/public/c.png    | 2       |
      | 3a    | CSS   | MIDDLE  | https://www.anthogdn.fr/public/css.png  | 3       |

  Scenario: I make call to GET /tools without query parameters.
    When I set a "GET" request to "/api/tools"
    And I send the request
    Then the response status code is 200
    And the "Content-Type" attribute of the response header is "application/json;charset=UTF-8"
    And the response body matches :
      | content[0].id           | 0a                                      |
      | content[0].name         | JAVA                                    |
      | content[0].level        | HIGH                                    |
      | content[0].imgURL       | https://www.anthogdn.fr/public/java.png |

      | content[1].id           | 1a                                      |
      | content[1].name         | PHP                                     |
      | content[1].level        | GOOD                                    |
      | content[1].imgURL       | https://www.anthogdn.fr/public/php.png  |

      | content[2].id           | 2a                                      |
      | content[2].name         | C                                       |
      | content[2].level        | MIDDLE                                  |
      | content[2].imgURL       | https://www.anthogdn.fr/public/c.png    |

      | content[3].id           | 3a                                      |
      | content[3].name         | CSS                                     |
      | content[3].level        | MIDDLE                                  |
      | content[3].imgURL       | https://www.anthogdn.fr/public/css.png  |

      | last                    | true                                    |
      | totalElements           | 4                                       |
      | totalPages              | 1                                       |
      | first                   | true                                    |
      | numberOfElements        | 4                                       |
      | size                    | 10                                      |
      | number                  | 0                                       |

  Scenario: I make call to GET /tools with page = 0 and perPage = 2.
    When I set a "GET" request to "/api/tools/?page=0&perPage=2"
    And I send the request
    Then the response status code is 200
    And the "Content-Type" attribute of the response header is "application/json;charset=UTF-8"
    And the response body matches :
      | content[0].id           | 0a                                      |
      | content[0].name         | JAVA                                    |
      | content[0].level        | HIGH                                    |
      | content[0].imgURL       | https://www.anthogdn.fr/public/java.png |

      | content[1].id           | 1a                                      |
      | content[1].name         | PHP                                     |
      | content[1].level        | GOOD                                    |
      | content[1].imgURL       | https://www.anthogdn.fr/public/php.png  |

      | last                    | false                                   |
      | totalElements           | 4                                       |
      | totalPages              | 2                                       |
      | first                   | true                                    |
      | numberOfElements        | 2                                       |
      | size                    | 2                                       |
      | number                  | 0                                       |


  Scenario: I make call to GET /tools with page = 1 and perPage = 2.
    When I set a "GET" request to "/api/tools/?page=1&perPage=2"
    And I send the request
    Then the response status code is 200
    And the "Content-Type" attribute of the response header is "application/json;charset=UTF-8"
    And the response body matches :

      | content[0].id           | 2a                                      |
      | content[0].name         | C                                       |
      | content[0].level        | MIDDLE                                  |
      | content[0].imgURL       | https://www.anthogdn.fr/public/c.png    |

      | content[1].id           | 3a                                      |
      | content[1].name         | CSS                                     |
      | content[1].level        | MIDDLE                                  |
      | content[1].imgURL       | https://www.anthogdn.fr/public/css.png  |

      | last                    | true                                    |
      | totalElements           | 4                                       |
      | totalPages              | 2                                       |
      | first                   | false                                   |
      | numberOfElements        | 2                                       |
      | size                    | 2                                       |
      | number                  | 1                                       |