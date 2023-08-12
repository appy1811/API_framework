Feature: Api Testing
  Verify the APIs forReqres.in

  Scenario: Verify the get call for single user
    When User sends "Get" request with "/api/users/2" endpoint
    Then User verifies the status ccode is "200"
    And User verifies the response contains following details
    |id|email|first_name|last_name|
    |2 |janet.weaver@reqres.in     |Janet     |Weaver   |
