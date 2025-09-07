Feature: Test West Florida AHEC Website

  @Home
  Scenario: Verify homepage search and banner
    Given user launches browser
    When user navigates to homepage
    And user searches for "Tambacoo"
    And user goes back to homepage
    And user clicks banner and navigates back
    Then homepage test executed

  @Programs
  Scenario: Verify Program section navigation
    Given user launches browser
    When user navigates to homepage
    And user hovers on Programs menu
    And user clicks on Tobacco Free Florida
    And user clicks on AHEC Scholars
    And user clicks on Healthy Aging
    And user clicks on Covering Florida
    Then Programs section test executed

  @Registration
  Scenario: Verify Registration functionality
    Given user launches browser
    When user navigates to registration page
    And user enters username "AyushShah2001"
    And user enters email "jyotirmay@gmail.com"
    And user enters password "Test@12345"
    And user clicks on register
    Then registration test executed

  @Login
  Scenario: Verify Login functionality
    Given user launches browser
    When user navigates to login page
    And user enters login username "jyotirmay123@test.com"
    And user enters login password "Test@12345"
    And user clicks on login
    Then login test executed

  @Contact
  Scenario: Verify Contact Us page
    Given user launches browser
    When user navigates to contact us page
    Then contact us page test executed
