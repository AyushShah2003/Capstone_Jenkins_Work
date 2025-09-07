Feature: West Florida AHEC Website Tests
  This feature tests the main functionalities of the West Florida AHEC website including Home, Program, Registration, Login, and Contact Us.

  @HomePage
  Scenario: Home Page Test
    Given I open the browser
    When I go to the home page
    Then I search for "Tobacco"
    And I click on the banner
    Then I close the browser

  @ProgramSection
  Scenario: Program Section Test
    Given I open the browser
    When I go to the home page
    #Then I open the program "Tobacco Free Florida AHEC Cessation Program"
    Then I open the program "AHEC Scholars"
    Then I open the program "Healthy Aging"
    Then I close the browser

  @Registration
  Scenario: Registration Test
    Given I open the browser
    When I go to the registration page
    And I register with username "AyushShah" and password "Test@12345"
    Then I should be registered successfully
    Then I close the browser

  @Login
  Scenario: Login Test
    Given I open the browser
    When I go to the login page
    And I login with username "01ayushshah@gmail.com" and password "Test@12345"
    Then I should be logged in successfully
    Then I close the browser

  @ContactUs
  Scenario: Contact Us Test
    Given I open the browser
    When I go to the contact us page
    Then I click on the email link
    Then I close the browser
