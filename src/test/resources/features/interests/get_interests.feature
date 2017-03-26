Feature: Get All interests

  Background:
    Given there are these interests data in database:
      | id | name        | url                                            | type           | orderNb |
      | 0a | Programming | https://www.anthogdn.fr/public/programming.png | Passions       | 0       |
      | 1a | Trips       | https://www.anthogdn.fr/public/trips.png       | Passions       | 1       |
      | 2a | Sport       | https://www.anthogdn.fr/public/sport.png       | Entertainments | 2       |
      | 3a | Movies      | https://www.anthogdn.fr/public/movies.png      | Entertainments | 3       |

  Scenario: I make call to GET /interests without query parameters.
    When I set a "GET" request to "/api/interests"
    And I send the request
    Then the response status code is 200
    And the "Content-Type" attribute of the response header is "application/json;charset=UTF-8"
    And the response body matches :
      | content[0].id     | 0a                                             |
      | content[0].name   | Programming                                    |
      | content[0].imgURL | https://www.anthogdn.fr/public/programming.png |
      | content[0].type   | Passions                                       |

      | content[1].id     | 1a                                             |
      | content[1].name   | Trips                                          |
      | content[1].imgURL | https://www.anthogdn.fr/public/trips.png       |
      | content[1].type   | Passions                                       |

      | content[2].id     | 2a                                             |
      | content[2].name   | Sport                                          |
      | content[2].imgURL | https://www.anthogdn.fr/public/sport.png       |
      | content[2].type   | Entertainments                                 |

      | content[3].id     | 3a                                             |
      | content[3].name   | Movies                                         |
      | content[3].imgURL | https://www.anthogdn.fr/public/movies.png      |
      | content[3].type   | Entertainments                                 |

      | last              | true                                           |
      | totalElements     | 4                                              |
      | totalPages        | 1                                              |
      | first             | true                                           |
      | numberOfElements  | 4                                              |
      | size              | 10                                             |
      | number            | 0                                              |

  Scenario: I make call to GET /interests with page = 0 and perPage = 2.
    When I set a "GET" request to "/api/interests/?page=0&perPage=2"
    And I send the request
    Then the response status code is 200
    And the "Content-Type" attribute of the response header is "application/json;charset=UTF-8"
    And the response body matches :
      | content[0].id     | 0a                                             |
      | content[0].name   | Programming                                    |
      | content[0].imgURL | https://www.anthogdn.fr/public/programming.png |
      | content[0].type   | Passions                                       |

      | content[1].id     | 1a                                             |
      | content[1].name   | Trips                                          |
      | content[1].imgURL | https://www.anthogdn.fr/public/trips.png       |
      | content[1].type   | Passions                                       |

      | last              | false                                          |
      | totalElements     | 4                                              |
      | totalPages        | 2                                              |
      | first             | true                                           |
      | numberOfElements  | 2                                              |
      | size              | 2                                              |
      | number            | 0                                              |


  Scenario: I make call to GET /interests with page = 1 and perPage = 2.
    When I set a "GET" request to "/api/interests/?page=1&perPage=2"
    And I send the request
    Then the response status code is 200
    And the "Content-Type" attribute of the response header is "application/json;charset=UTF-8"
    And the response body matches :

      | content[0].id     | 2a                                        |
      | content[0].name   | Sport                                     |
      | content[0].imgURL | https://www.anthogdn.fr/public/sport.png  |
      | content[0].type   | Entertainments                            |

      | content[1].id     | 3a                                        |
      | content[1].name   | Movies                                    |
      | content[1].imgURL | https://www.anthogdn.fr/public/movies.png |
      | content[1].type   | Entertainments                            |

      | last              | true                                      |
      | totalElements     | 4                                         |
      | totalPages        | 2                                         |
      | first             | false                                     |
      | numberOfElements  | 2                                         |
      | size              | 2                                         |
      | number            | 1                                         |