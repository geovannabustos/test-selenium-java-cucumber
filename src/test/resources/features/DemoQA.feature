Feature: DemoQA

  @DemoQA
  Scenario Outline: Fill out the form
    Given I have DemoQA url
    When I fill out the form Text Box, with userName "<userName>", userEmail "<userEmail>", currentAddress "<currentAddress>", permanentAddress "<permanentAddress>"
    And I press enter Submit
    Then I see information, userName "<userName>", userEmail "<userEmail>", currentAddress "<currentAddress>", permanentAddress "<permanentAddress>"

    Examples:
      | userName | userEmail        | currentAddress    | permanentAddress |
      | GEOVANNA | correo@gmail.com | Colinas del Norte | Guayaquil        |