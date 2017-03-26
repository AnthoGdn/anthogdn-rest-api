Feature: Add trainings

  Scenario: I make call to POST /trainings.
    When I set a "POST" request to "/api/trainings"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      [
        {
          "startDate":"2016-01-01",
          "endDate":"2017-01-01",
          "title":"Master's Degree",
          "description":"SOA and management",
          "location":"Rouen"
        },{
          "startDate":"2015-01-01",
          "endDate":"2016-01-01",
          "title":"Bachelor's Degree",
          "description":"Java",
          "location":"Rouen"
        }
      ]
    """
    And I send the request
    Then the response status code is 201
    And the "Content-Type" attribute of the response header is "application/json;charset=UTF-8"
    And the response body matches :
      | [0].title       | Master's Degree    |
      | [0].description | SOA and management |
      | [0].location    | Rouen              |

      | [1].title       | Bachelor's Degree  |
      | [1].description | Java               |
      | [1].location    | Rouen              |

  Scenario: I make call to POST bad training.
    When I set a "POST" request to "/api/trainings"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      {
        "startDate":"2016-01-01",
        "endDate":"2017-01-01",
        "title":"Master's Degree",
        "description":"SOA and management",
        "location":"Rouen",
      }
    """
    And I send the request
    Then the response status code is 400