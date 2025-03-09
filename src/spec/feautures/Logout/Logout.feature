@Logout
Feature: Logout
  En tant qu'utilisateur, je souhaite tester la fonctionnalité de déconnexion

  Background:
    Given je me connecte sur l'application Orange
    When Je saisis le username "Admin"
    And Je saisis le mot de passe "admin123"
    And je clique sur le bouton login
    Then redirection vers la page Dashboard 

  @Logout_valid
  Scenario: Déconnexion de l'application
    When je clique sur la liste déroulante
    And je clique sur logout
    Then je suis redirigé vers la page d'authentification 
