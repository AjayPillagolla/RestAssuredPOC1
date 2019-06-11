Feature: To Verify the response for getCategoryDetails

#  Scenario Outline: To verify the response for getDetailsByCategoryId
#    When the user sends a request with categoryID <catID>
#
#    Examples:
#    |catID|
#    |100000002001|

  Scenario Outline: To verify the response for getDetailsByCategoryId
   When the user sends a request with categoryID <catId>
    And The user validates the Json Schema with schema at "<schemaPath>"

    Examples:
    |catId|schemaPath|
    |100087|response/TAXONOMY_RESPONSE_SCHEMA.json|
