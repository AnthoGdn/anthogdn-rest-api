Feature: Get All trainings

  Background:
    Given there are these trainings data in database:
      | id | startDate  | endDate    | title             | description        | location | orderNb |
      | 0a | 2016-01-01 | 2017-01-01 | Master's Degree   | SOA and management | Rouen    | 0       |
      | 1a | 2015-01-01 | 2016-01-01 | Bachelor's Degree | Java               | Rouen    | 0       |

  Scenario: I make call to GET /trainings without query parameters.
    When I set a "GET" request to "/api/trainings"
    And I send the request
    Then the response status code is 200
    And the "Content-Type" attribute of the response header is "application/json;charset=UTF-8"
    And the response body matches :
      | content[0].id          | 0a                 |
      | content[0].title       | Master's Degree    |
      | content[0].description | SOA and management |
      | content[0].location    | Rouen              |

      | content[1].id          | 1a                 |
      | content[1].title       | Bachelor's Degree  |
      | content[1].description | Java               |
      | content[1].location    | Rouen              |

      | last                   | true               |
      | totalElements          | 2                  |
      | totalPages             | 1                  |
      | first                  | true               |
      | numberOfElements       | 2                  |
      | size                   | 10                 |
      | number                 | 0                  |