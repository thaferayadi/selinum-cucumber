
@Home
Feature: Title of your feature
  I want to use this template for my feature file

    Background:
    Given je me connecte sur l'application Orange
    When Je saisis le username "Admin"
    And Je saisis le mot de passe "admin123"
    And je clique sur le bouton login
    Then redirection vers la page Dashboard 
    @Home_valid
  	Scenario: click sur le navbarhome
  	When je click sur claim
  	Then je suis réderigé vers la page claim

