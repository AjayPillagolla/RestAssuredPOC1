Feature: To Verify the response for getCategoryDetails


  Scenario Outline: To verify the response for getDetailsByCategoryId
   When the user sends a request with categoryID <catId>
   Then  the user verify that the status code is <StatusCode>
   And  the status line is "<StatusLine> "
   And The user validates the Json Schema with schema at "<schemaPath> "
   And  the user validates the response header

   Examples:
    |catId|schemaPath|StatusCode|StatusLine|
    |100087|response/TAXONOMY_RESPONSE_SCHEMA.json|200|HTTP/1.1 200 |
