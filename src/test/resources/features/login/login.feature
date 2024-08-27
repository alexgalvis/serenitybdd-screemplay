Feature: login in to application

  Scenario: successful login
    Given Sergey has an active account
    When  he sends their valid credentials
    Then  he should have access to manege his account