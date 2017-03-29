Feature: Get All experiences

  Background:
    Given there are these experiences data in database:
      | id | startDate  | endDate    | title             | languages | job      | description        | location | orderNb |
      | 0a | 2016-01-01 | 2017-01-01 | Master's Degree   | Spring    | Stage    | SOA and management | Rouen    | 0       |
      | 1a | 2015-01-01 | 2016-01-01 | Bachelor's Degree | JAVA - C  | Etudiant | Java               | Rouen    | 1       |

  Scenario: I make call to GET /experiences without query parameters.
    When I set a "GET" request to "/api/experiences"
    And I send the request
    Then the response status code is 200
    And the "Content-Type" attribute of the response header is "application/json;charset=UTF-8"
    And the response body matches :
      | content[0].id          | 0a                 |
      | content[0].title       | Master's Degree    |
      | content[0].languages   | Spring             |
      | content[0].job         | Stage              |
      | content[0].description | SOA and management |
      | content[0].location    | Rouen              |

      | content[1].id          | 1a                 |
      | content[1].title       | Bachelor's Degree  |
      | content[1].languages   | JAVA - C           |
      | content[1].job         | Etudiant           |
      | content[1].description | Java               |
      | content[1].location    | Rouen              |

      | last                   | true               |
      | totalElements          | 2                  |
      | totalPages             | 1                  |
      | first                  | true               |
      | numberOfElements       | 2                  |
      | size                   | 10                 |
      | number                 | 0                  |