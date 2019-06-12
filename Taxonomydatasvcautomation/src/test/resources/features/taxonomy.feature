Feature: To Verify the response for getAttributesByCategory

  Scenario Outline:getAttributesByCategory happypath
   When the user sends a request with categoryID <catId>
   Then  the user verify that the status code is <StatusCode>
   And  the status line is "<StatusLine> "
   And  the user validates the response header
   And verify that response has attributes array
   And the response has parents array

   Examples:
    |catId|schemaPath|StatusCode|StatusLine|
    |100087|response/TAXONOMY_RESPONSE_SCHEMA.json|200|HTTP/1.1 200 |
