@Login
Feature: Login
  En tant qu'utilisateur, je souhaite tester la page de connexion

  @Login_valid_credential
  Scenario: Login avec des données valides
    Given je me connecte sur l'application Orange
    When Je saisis le username "Admin"
    And Je saisis le mot de passe "admin123"
    And je clique sur le bouton login
    Then redirection vers la page Dashboard 

