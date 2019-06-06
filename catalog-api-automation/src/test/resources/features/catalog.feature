Feature: To Verify the Response for RelatedItems Association Type

  @Catalog
  Scenario Outline: To verify the response for getDetailsByCategoryId
    When the user sends a request with categoryID "<categoryId>"
    Then the user verify that the status code is <StatusCode>
    And  the user validate that "<JsonPath>" is "<association_type>"
    And  the status line is "<StatusLine>"
    And  the user validates that "associatedItems" has item "<Item_ID>"
    And  the user validates the response for associatedItems
    And  the user validates the response header
    And  The user validates the Json Schema with schema at "<schemaPath>"

    Examples:
      | category_Id  |  StatusCode| JsonPath       | StatusLine      | schemaPath                    |
      | 1000336995   | 200        |associationType | HTTP/1.1 200 OK | response/RESPONSE_SCHEMA.json |
      | 1000336987   | 200        |associationType | HTTP/1.1 200 OK | response/RESPONSE_SCHEMA.json |
