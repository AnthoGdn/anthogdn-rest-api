Feature: Add interests

  Scenario: I make call to POST /interests.
    When I set a "POST" request to "/api/interests"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      [
        {
          "name":"Programming",
          "imgURL":"https://www.anthogdn.fr/public/programming.png",
          "type":"Passions"
        },{
          "name":"Trips",
          "imgURL":"https://www.anthogdn.fr/public/trips.png",
          "type":"Passions"
        },{
          "name":"Sport",
          "imgURL":"https://www.anthogdn.fr/public/sport.png",
          "type":"Entertainments"
        },{
          "name":"Movies",
          "imgURL":"https://www.anthogdn.fr/public/movies.png",
          "type":"Entertainments"
        }
      ]
    """
    And I send the request
    Then the response status code is 201
    And the "Content-Type" attribute of the response header is "application/json;charset=UTF-8"
    And the interests data database is:
      | name        | url                                            | type           | orderNb |
      | Programming | https://www.anthogdn.fr/public/programming.png | Passions       | 0       |
      | Trips       | https://www.anthogdn.fr/public/trips.png       | Passions       | 1       |
      | Sport       | https://www.anthogdn.fr/public/sport.png       | Entertainments | 2       |
      | Movies      | https://www.anthogdn.fr/public/movies.png      | Entertainments | 3       |
    And the response body matches :
      | [0].name   | Programming                                    |
      | [0].imgURL | https://www.anthogdn.fr/public/programming.png |
      | [0].type   | Passions                                       |

      | [1].name   | Trips                                          |
      | [1].imgURL | https://www.anthogdn.fr/public/trips.png       |
      | [1].type   | Passions                                       |

      | [2].name   | Sport                                          |
      | [2].imgURL | https://www.anthogdn.fr/public/sport.png       |
      | [2].type   | Entertainments                                 |

      | [3].name   | Movies                                         |
      | [3].imgURL | https://www.anthogdn.fr/public/movies.png      |
      | [3].type   | Entertainments                                 |

  Scenario: I make call to POST bad interest.
    When I set a "POST" request to "/api/interests"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      {
        "toto":"Programming",
        "imgURL":"https://www.anthogdn.fr/public/programming.png",
        "type":"Passions"
      }
    """
    And I send the request
    Then the response status code is 400