

Framework de Tests hybride OpenCart avec Maven et Selenium WebDriver
Table des matières
Introduction
Mise en place du projet
Configuration et structure du framework
Exécution des tests
Conclusion
1. Introduction
Ce document fournit une documentation détaillée sur la mise en place et l'utilisation d'un framework de tests automatisés pour l'application OpenCart, en utilisant Maven et Selenium WebDriver.

2. Mise en place du projet
Pour commencer:

Étape 1: Créez un nouveau projet Java de type Maven.

Étape 2: Dans le pom.xml, ajoutez toutes les dépendances nécessaires pour votre projet (TestNG, Selenium, POI, etc.).

Étape 3: Configurez le plugin surefire pour exécuter les tests avec Maven en spécifiant le fichier testng.xml (ce fichier peut être généré via la conversion "Convert to TestNG").

3. Configuration et structure du framework
src/main/java

config.properties: Contient toutes les configurations communes (URL, navigateur, mot de passe, etc.).
Package pages

Chaque classe se termine par le mot "Page". Ces classes contiennent les éléments web (@FindBy) et les méthodes associées utilisant PageFactory.
Package Utils

Contient des méthodes utilitaires statiques qui seront utilisées dans les tests, telles que la génération d'e-mails avec des timestamps, la manipulation de fichiers Excel, et la prise de captures d'écran.
Package test data

Stocke les données nécessaires pour les tests sous divers formats comme Excel ou JSON.
Package Listeners

Utilisé pour le suivi des tests. Grâce à TestNG, les listeners suivent l'exécution des tests et décident des étapes à suivre en cas de réussite ou d'échec des tests.
Src/test/java

Contient les classes de test. Toutes ces classes doivent se terminer par "Test" car TestNG recherche le mot "Test" pour identifier les classes de test.
Classe de base (Base)

Cette classe contient toutes les méthodes communes utilisées dans les tests. Les méthodes ou variables qui ne changent pas ou qui sont fréquemment utilisées peuvent être définies comme static pour éviter d'avoir à créer une instance à chaque fois.
4. Exécution des tests
Pour exécuter les tests via l'IDE: Clic droit sur le projet -> "Run as" -> "Maven test".

Pour exécuter les tests via la ligne de commande (utile pour l'intégration CICD): Ouvrez gitbash ou un terminal à l'emplacement du projet et exécutez mvn test.

5. Fonctionnalités à tester
Exigence No 01: L'utilisateur peut s'inscrire en fournissant tous les champs.
Exigence No 02: L'utilisateur peut s'inscrire avec option pour l'abonnement à la Newsletter.
Exigence No 03: Impossibilité de création de compte en double.
Exigence No 04: Connexion avec informations d'identification valides.
Exigence No 05: Réinitialisation du mot de passe oublié.
Exigence No 06: Recherche de produits.
Exigence No 07: Notification si le produit recherché n'est pas disponible.
Exigence No 08: Passage d'une commande.
6. Prérequis
Java version 17
Maven
Dépendances (Voir section Configuration)
7. Configuration du projet
Assurez-vous d'inclure les dépendances nécessaires dans votre pom.xml (TestNG, Selenium, Apache POI, ExtentReports, Lombok, Logback).
