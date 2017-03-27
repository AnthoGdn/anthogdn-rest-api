Feature: Add experiences

  Scenario: I make call to POST /experiences.
    When I set a "POST" request to "/api/experiences"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      [
        {
          "startDate":"2016-01-01",
          "endDate":"2017-01-01",
          "title":"Master's Degree",
          "languages":"Spring",
          "partnerTeamNb":"7",
          "job":"Stage",
          "description":"SOA and management",
          "location":"Rouen"
        },{
          "startDate":"2015-01-01",
          "endDate":"2016-01-01",
          "title":"Bachelor's Degree",
          "languages":"JAVA - C",
          "partnerTeamNb":"7",
          "job":"Etudiant",
          "description":"Java",
          "location":"Rouen"
        }
      ]
    """
    And I send the request
    Then the response status code is 201
    And the "Content-Type" attribute of the response header is "application/json;charset=UTF-8"
    And the response body matches :
      | [0].title         | Master's Degree    |
      | [0].languages     | Spring             |
      | [0].job           | Stage              |
      | [0].description   | SOA and management |
      | [0].location      | Rouen              |

      | [1].title         | Bachelor's Degree  |
      | [1].languages     | JAVA - C           |
      | [1].job           | Etudiant           |
      | [1].description   | Java               |
      | [1].location      | Rouen              |

  Scenario: I make call to POST bad experience.
    When I set a "POST" request to "/api/experiences"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      {
        "endDate":"2017-01-01",
        "title":"Master's Degree",
        "description":"SOA and management",
        "location":"Rouen",
      }
    """
    And I send the request
    Then the response status code is 400