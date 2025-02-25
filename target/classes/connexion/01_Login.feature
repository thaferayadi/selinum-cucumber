
@Login
Feature: Login
En tant que utilisateur je souhaite tester la page de connexion
  @Login_valid_credential
  Scenario: Login avec des données valides
    Given je me connecte sur l'application Orange
    When Je saisie le username "Admin"
    And Je saisie le motPasse "admin 123"
    And je clique sur le boutton login
    Then rederaction vers la page Dashboard "Dashboard "

 